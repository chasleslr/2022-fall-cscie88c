package org.cscie88c.week4

object TrigUtils {

  // https://www.scala-lang.org/api/2.13.6/scala/math/index.html
  // use the function literal syntax for sin and cos
  val sinDegrees: Double => Double = (c: Double) => math.sin(c)
  val cosDegrees: Double => Double = (c: Double) => math.cos(c)

  // use the placeholder syntax for squared
  val squared: Double => Double = math.pow(_, 2.0)
  
}
