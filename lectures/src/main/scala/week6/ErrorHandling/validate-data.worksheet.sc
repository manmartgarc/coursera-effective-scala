type Errors = Seq[String]
type Validated[A] = Either[Errors, A]

val validInt: Validated[Int] = Right(42)
val invalidInt: Validated[Int] = Left(Seq("Error"))
println(validInt)
println(invalidInt)

validInt match
  case Right(n)     => println(s"Got a valid integer: $n")
  case Left(errors) => println(s"Got validation errors: $errors")

validInt.map(n => n + n)
invalidInt.map(n => n + n)
