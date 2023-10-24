package week4

import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

class ProgramProperties extends munit.ScalaCheckSuite:
  val fibonacciDomain: Gen[Int] = Gen.choose(1, 46)
  property("fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2)") {
    forAll(fibonacciDomain.suchThat(n => n >= 3)) { (n: Int) =>
      fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  property("fibonacci numbers are positive") {
    forAll(fibonacciDomain) { (n: Int) =>
      fibonacci(n) >= 0
    }
  }
