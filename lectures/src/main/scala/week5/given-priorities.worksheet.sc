trait LowPriorityInstances:
  given intOrdering: Ordering[Int] = Ordering.Int

object Main extends LowPriorityInstances:

  given intReverseOrdering: Ordering[Int] = Ordering.Int.reverse

  def main(args: Array[String]): Unit =
    println(List(1, 2, 3).min)

Main.main(Array.empty)
