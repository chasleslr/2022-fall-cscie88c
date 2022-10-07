package org.cscie88c.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] = LazyList.range(0, 100, 5)

  val randIntStream: LazyList[Int] = LazyList.continually(rnd.between(0, 15))

  val dogs: LazyList[Dog] = LazyList.continually(
    Dog("dog" + uuid, rnd.between(0, 15), rnd.nextBoolean())
  )

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = dogs.filter(_.hasCurrentShots == true)

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = {
    val sample = healthyDogs(dogs).take(sampleSize)
    sample.map(_.age).sum / sample.length
  }


}
