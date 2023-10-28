trait Ordering[A]:
  def compare(x: A, y: A): Int

object Ordering:
  given Int: Ordering[Int] with
    def compare(x: Int, y: Int) =
      if x < y then -1 else if x > y then 1 else 0
  given String: Ordering[String] with
    def compare(x: String, y: String) =
      x.compareTo(y)

// we say that Ordering is a type class, and Int and String are instances of the type class

def allEqual[T](xs: List[T])(using Ordering[T]): Boolean = xs match
  case Nil          => true
  case x :: Nil     => true
  case x :: y :: ys => x == y && allEqual(y :: ys)

case class Rational(num: Int, denom: Int)

// can extend without modifying the original code
given Ordering[Rational] with
  def compare(x: Rational, y: Rational) =
    (x.num * y.denom) - (y.num * x.denom)

val rationals = List(Rational(1, 2), Rational(3, 4), Rational(1, 3))
val equalRationals = List(Rational(2, 4), Rational(2, 4), Rational(2, 4))
allEqual(rationals)
allEqual(equalRationals)
allEqual(equalRationals)

// can also define subtyping relationships
trait Comparable:
  def compareTo(that: Comparable): Int

case class Rational2(num: Int, denom: Int) extends Comparable:
  def compareTo(that: Comparable): Int =
    val thatRational = that.asInstanceOf[Rational2]
    (this.num * thatRational.denom) - (thatRational.num * this.denom)

def allEqual2[T <: Comparable](xs: List[T]): Boolean = xs match
  case Nil          => true
  case x :: Nil     => true
  case x :: y :: ys => x.compareTo(y) == 0 && allEqual2(y :: ys)

val rationals2 = List(Rational2(1, 2), Rational2(3, 4), Rational2(1, 3))
allEqual2(rationals2)
