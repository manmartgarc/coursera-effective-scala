package week6.ErrorHandling

import scala.io.Source
import scala.util.{Using, Try, Success, Failure}
import java.time.LocalDate

type Errors = Seq[String]
type Validated[A] = Either[Errors, A]

def validateBoth[A, B](
    validatedA: Validated[A],
    validatedB: Validated[B]
): Validated[(A, B)] =
  (validatedA, validatedB) match
    case (Right(a), Right(b)) => Right((a, b))
    case (Left(e), Right(_))  => Left(e)
    case (Right(_), Left(e))  => Left(e)
    case (Left(e1), Left(e2)) => Left(e1 ++ e2)

def validateEach[A, B](as: Seq[A])(
    validate: A => Validated[B]
): Validated[Seq[B]] =
  as.foldLeft[Validated[Seq[B]]](Right(Vector.empty)) { (validtedBs, a) =>
    val validatedB: Validated[B] = validate(a)
    validateBoth(validtedBs, validatedB)
      .map((bs, b) => bs :+ b)
  }

def parseDate(str: String): Validated[LocalDate] =
  Try(LocalDate.parse(str)) match
    case Failure(exn)  => Left(Seq(exn.getMessage))
    case Success(date) => Right(date)

def readDateStrings(fileName: String): Try[Seq[String]] =
  Using(Source.fromFile(fileName)) { source =>
    source.getLines().toSeq
  }

def readAndParseDates(fileName: String): Try[Validated[Seq[LocalDate]]] =
  readDateStrings(fileName).map { dateStrings =>
    validateEach(dateStrings)(parseDate)
  }

@main def runDates: Unit =
  val fileName = "./src/main/scala/week6/dates-file.txt"
  readAndParseDates(fileName) match
    case Failure(exception) =>
      System.err.println(s"Unable to parse dates file: $exception")
    case Success(validatedDates) =>
      validatedDates match
        case Left(errors) =>
          println(s"Invalid data: ${errors.mkString(", ")}")
        case Right(dates) =>
          println(s"Successfully parsed dates: ${dates.mkString(", ")}")
