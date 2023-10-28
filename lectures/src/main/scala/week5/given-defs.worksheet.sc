trait Ordering[A]:
  // This is an abstract method.
  def compare(x: A, y: A): Int
  // This is a concrete method.
  extension (lhs: A)
    def < (rhs: A) = Boolean = compare(lhs, rhs) < 0

object Ordering:
  given Int: Ordering[Int] with
    def compare(x: Int, y: Int) =
      if x < y then -1 else if x > y then 1 else 0
  given String: Ordering[String] with
    def compare(x: String, y: String): Int = x.compareTo(y)

def allEqual[T](xs: List[T])(using Ordering[T]): Boolean = xs match
  case Nil          => true
  case x :: Nil     => true
  case x :: y :: ys => x == y && allEqual(y :: ys)

allEqual(List(1, 1, 1))
allEqual(List(1, 2, 1))
allEqual(List("a", "a", "a"))
allEqual(List("a", "b", "a"))
