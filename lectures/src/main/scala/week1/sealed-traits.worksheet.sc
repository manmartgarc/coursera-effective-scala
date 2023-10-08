// Sealed keyword is less restrictive than final. We can extend the trait
// but only within the same source file.
sealed trait Shape
case class Rectangle(width: Int, height: Int) extends Shape
case class Circle(radius: Int) extends Shape

val one = 1 + 1
val someRectangle: Rectangle = Rectangle(1, 2)
val someShape: Shape = someRectangle

val someShapeArea = someShape match
  case Rectangle(width, height) => width * height
  case Circle(radius)           => radius * radius * math.Pi
