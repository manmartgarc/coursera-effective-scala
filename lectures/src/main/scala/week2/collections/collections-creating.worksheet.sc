import scala.collection.mutable

List.empty[Int]
mutable.ArrayBuffer.empty[Double]
Map.empty[String, Boolean]

List(1, 2, 3, 4)
mutable.ArrayBuffer("a", "b", "c", "d")
Map("a" -> true, "e" -> true, "b" -> false)

// matching tuple patterns
(10.0, "Hello") match
  case (number, greeting) => s"$greeting! The number is $number"

// tuple unpacking
val (x, y) = (10.0, 20.0)
x
y

val pair = ("Alice", 42)
pair(0)
pair(1)

List(1, 2, 3) :+ 4
1 +: List(2, 3, 4)
mutable.ArrayBuffer("a", "b") :+ "c"

Map("a" -> true) + ("b" -> false)