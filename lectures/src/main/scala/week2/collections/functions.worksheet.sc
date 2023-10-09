val increment: Int => Int =
  x =>
    val result = x + 1
    result

// Compiler will infer the result type but not the parameter types.
val add = (x: Int, y: Int) => x + y
add(1, increment(2))

// this is a method
def increment2(x: Int): Int = x + 1

// this is a value (an object)
val increment3: Int => Int = x => x + 1

increment2(41)
// this is actually rewritten to obj.apply by the compiler
increment3(41)
increment3.apply(41)

val xs = List(1, 2, 3)
xs.map(increment)