given orderingPair[A, B](using
    ordA: Ordering[A],
    ordB: Ordering[B]
): Ordering[(A, B)] with
  def compare(x: (A, B), y: (A, B)): Int =
    val res = ordA.compare(x._1, y._1)
    if res == 0 then ordB.compare(x._2, y._2) else res

val addresses = List(
  (2610, "Kouweheide"),
  (2600, "Halewijllaan"),
  (2060, "Fort VII straat")
)

addresses.sorted
