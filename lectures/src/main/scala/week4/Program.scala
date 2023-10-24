package week4

import scala.annotation.tailrec

def add(x: Int, y: Int): Int = x + y

def fibonacci(n: Int): Int =
  @tailrec
  def loop(n: Int, prev: Int, curr: Int): Int =
    if n == 0 then prev
    else loop(n - 1, curr, prev + curr)
  loop(n, 0, 1)
