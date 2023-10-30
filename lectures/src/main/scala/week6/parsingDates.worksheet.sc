import scala.util.Using
import java.time.LocalDate
import scala.util.{Success, Try}
import scala.io.Source

def parseDate(str: String): Try[LocalDate] = Try(LocalDate.parse(str))

def readDateStrings(fileName: String): Try[Seq[String]] =
  Using(Source.fromFile(fileName)) { source =>
    source.getLines().toSeq
  }

def parseDates(fileName: String): Try[Seq[LocalDate]] =
  readDateStrings(fileName).flatMap { (dateStrings: Seq[String]) =>
    dateStrings.foldLeft[Try[Seq[LocalDate]]](Success(Vector.empty)) {
      (tryDates, dateString) =>
        for
          dates <- tryDates
          date <- parseDate(dateString)
        yield dates :+ date
    }
  }

parseDates("./src/main/scala/week6/dates-file.txt")
