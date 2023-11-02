import scala.util.Try
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
  Try {
    LocalDate.parse(str)
  }.toEither.left.map(e => Seq(e.getMessage))

def parseDates(strs: Seq[String]): Validated[Seq[LocalDate]] =
  validateEach(strs)(parseDate)

parseDates(List("2020-01-04", "2020-08-09"))
parseDates(List("not a date", "not a date either"))
