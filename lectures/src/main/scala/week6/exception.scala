package week6

import scala.util.control.NonFatal

def attemptSomethingOld(): Unit =
  println("So far, so good")
  println("Still there")
  throw RuntimeException("We can't continue")
  println("You will never see this message")

@main def runException(): Unit =
  try
    "3".toInt
    println("Mission accomplished")
  catch
    case NonFatal(exn) =>
      println("Oh no!")
  finally println("Who knows what could happen?")
