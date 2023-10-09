def factorialColl(n: Int): Int =
  // (1 to n).foldLeft(1)((result, x) => result * x)
  (1 to n).product

def factorialImper(n: Int): Int =
  var acc = 1
  var i = 1
  while i < n do
    i += 1
    acc *= i
  acc

def factorialRec(n: Int): Int =
  if n == 0 then 1
  else n * factorialRec(n - 1)

factorialColl(10)
factorialImper(10)
factorialRec(10)

(1 to 4).map(x => x)
(0 to 10 by 2).map(x => x)
(5 until 0 by -1).map(x => x)
