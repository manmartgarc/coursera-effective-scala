def showPrice(paintingArea: Double, paintPrice: Double): String =
  val price = paintingArea * paintPrice
  if price > 100 then "This is too expensive" else price.toString

showPrice(10, 50)
showPrice(100, 0.1)
