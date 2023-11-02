package week6.ErrorHandling

import scala.util.{Try, Success, Failure}

def attemptSomething(): Try[Unit] =
  Try {
    println("So far, so good")
    println("Still there")
    throw RuntimeException("We can't continue")
    println("You will never see this message")
  }

@main def runTry: Unit =
  // way one
  attemptSomething() match
    case Success(_) => println("Mission accomplished")
    case Failure(exn) =>
      System.err.println(s"Something went wrong: $exn")
      println("Stopping the program")

  // way two
  attemptSomething()
    .recover { case exn: RuntimeException =>
      System.err.println(s"Something went wrong: $exn")
      println("Stopping the program")
    }
