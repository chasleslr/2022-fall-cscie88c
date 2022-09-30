package org.cscie88c.week3

object UtilFunctions {

  def mult2(x: Int, y: Int): Int = x * y

  def pythTest(
      x: Int,
      y: Int,
      z: Int
    ): Boolean =
    scala.math.pow(x, 2) + scala.math.pow(y, 2) == scala.math.pow(z, 2)
  val pythTriplesUpto100: List[(Int, Int, Int)] = {
    for {
      i <- List.range(1, 100)
      j <- List.range(1, 100)
      k <- List.range(1, 100)
      if pythTest(i, j, k)
    } yield (i, j, k)
  }
}
