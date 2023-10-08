case class Rectangle(width: Int, height: Int):
  val area: Int = width * height

val r1 = Rectangle(5, 3)
r1.width * r1.height
r1.area

case class Square(width: Int):
  val area: Int = width * width

Square(8).area

case class Circle(radius: Int):
  val area: Double = math.Pi * Math.pow(radius, 2)

val c1 = Circle(5)
c1.area

// Case classes generate immutable data types.
// We can generate copies:
val c2 = c1.copy(radius = c1.radius * 2)
c2.area