class Generator(previous: Int):
  def nextInt(): (Int, Generator) =
    val result = previous * 22_695_477 + 1
    (result, Generator(result))

  def between(x: Int, y: Int): (Int, Generator) =
    val min = math.min(x, y)
    val delta = math.abs(x - y)
    val (randomValue, nextGenerator) = nextInt()
    ((randomValue % delta) + min, nextGenerator)

object Generator:
  def init: Generator = Generator(42)

val (windowSide, gen1) = Generator.init.between(1, 4)
val windowArea = windowSide * windowSide
windowArea

def windowSideAndgen1 = Generator.init.between(1, 4)
def windowAreaDef = windowSideAndgen1(0) * windowSideAndgen1(0)
windowAreaDef
