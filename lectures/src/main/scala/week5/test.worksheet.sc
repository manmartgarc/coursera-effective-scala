import scala.language.implicitConversions

case class Rational(numerator: Int, denominator: Int)

object Rational:
  given fromInt: Conversion[Int, Rational] with
    def apply(n: Int): Rational = Rational(n, 1)

val r: Rational = 42
println(r)