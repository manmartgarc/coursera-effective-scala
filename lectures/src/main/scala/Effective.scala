@main def run(name: String, age: Int): Unit =
  println(
    "Hello, %s! You are %s years old today.".format(
      fansi.Color.Red(name.capitalize),
      fansi.Color.Cyan(age.toString)
    )
  )
