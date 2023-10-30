package week6

import java.time.{LocalDate, Period}
import scala.util.Try

def parseDate(str: String): Try[LocalDate] = Try(LocalDate.parse(str))

def tryPeriodFirst(str1: String, str2: String): Try[Period] =
  parseDate(str1).flatMap { (date1: LocalDate) =>
    parseDate(str2).map { (date2: LocalDate) =>
      Period.between(date1, date2)
    }
  }

def tryPeriod(str1: String, str2: String): Try[Period] =
  for
    date1 <- parseDate(str1)
    date2 <- parseDate(str2)
  yield Period.between(date1, date2)

@main def runDate: Unit =
  println(tryPeriodFirst("2020-07-27", "2020-12-25"))
  println(tryPeriodFirst("2020-19-27", "2020-12-25"))
  println(tryPeriod("2020-07-27", "2020-12-25"))
  println(tryPeriod("2020-19-27", "2020-12-25"))
