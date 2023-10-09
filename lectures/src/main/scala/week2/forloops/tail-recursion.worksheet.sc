import scala.annotation.tailrec

def factorialBad(n: Int): Int =
  if n == 0 then 1
  else n * factorialBad(n - 1)

factorialBad(3)

// factorial(3)
// 3 * factorial(3 - 1)
// 3 * 2 * factorial(2 - 1)
// 3 * 2 * 1 * factorial(1 - 1)
// 3 * 2 * 1 * 1
// 6

def factorial(n: Int): Int =
  @tailrec
  def loop(x: Int, acc: Int): Int =
    if x == 0 then 1
    else if x == 1 then acc
    else loop(x - 1, x * acc)
  loop(n, 1)

factorial(3)

// factorial(3)
// loop(3, 1)
// loop(3 - 1, 3 * 1)
// loop(2, 3)
// loop(2 - 1, 2 * 3)
// loop(1, 6)
// loop(1 - 1, 1 * 6)
// loop(0, 6)
// 6
