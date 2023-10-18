@main def run(name: String): Unit =
  println("Hello, %s!".format(fansi.Color.Red(name.capitalize)))
