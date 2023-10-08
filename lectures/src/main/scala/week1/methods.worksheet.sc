def house(facade: Double, window: Double): Double =
  val door = 2 * 1
  val subtractedArea = door + window * 2
  facade - subtractedArea

house(5 * 3, 1 * 1)
house(4 * 4, 1.5 * 1)

def marathonDuration(speed: Double): Double =
  val distance = 42.195 // (km)
  val duration = distance / speed
  duration * 60 // (minutes)

marathonDuration(12)
marathonDuration(14)
