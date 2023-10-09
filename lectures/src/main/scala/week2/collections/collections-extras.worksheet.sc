import scala.collection.mutable

List(1, 2, 3) :+ 4
List(1, 2, 3) ++ List(4, 5, 6)

// concatenation leaves the inputs untouched.
val first = mutable.ArrayBuffer("a", "b")
val second = mutable.ArrayBuffer("c", "d")
first ++ second
first
second

// we can edit in place with ++=
first ++= second
first
second

val data = mutable.ArrayBuffer(1, 2, 3)
data += 4
0 +=: data
data

var a = mutable.ArrayBuffer(1, 2, 3, 3, 4)
// removes first element equal to parameter
a -= 3
a

a = mutable.ArrayBuffer(1, 2, 3, 3, 4)
// removes all ements found in another collection
a --= List(3, 4, 5)
a

// Querying
val data1 = mutable.ArrayBuffer(1, 2, 3, 4)
// Is any element negative?
data1.exists(x => x < 0)
// Are all elements even?
data1.forall(x => x % 2 == 0)

val dataMut = mutable.HashMap.empty[String, Int]
dataMut += ("a" -> 0)
dataMut += ("b" -> 1)
dataMut += ("c" -> 2)
dataMut += ("d" -> 3)
dataMut