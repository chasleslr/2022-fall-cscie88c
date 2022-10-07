package org.cscie88c.week5

import scala.math

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = color.toLowerCase() match {
    case "black" => (0, 0, 0)
    case "white" => (255, 255, 255)
    case "red" => (255, 0, 0)
    case "lime" => (0, 255, 0)
    case "blue" => (0, 0, 255)
    case "yellow" => (255, 255, 0)
  }

  def fizzBuzzString(n: Int): String = n match {
    case n if (n >= 3) & (n % 3 == 0) & (n % 5 == 0) => "FizzBuzz"
    case n if (n >= 3) & (n % 3 == 0) => "Fizz"
    case n if (n >= 5) & (n % 5 == 0) => "Buzz"
    case _ => n.toString
  }

  def fizzBuzz(n: Int): List[String] = {
    (1 to n).map(fizzBuzzString(_)).toList
  }

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    case x if math.abs(x) != 90.0 => math.tan(x)
  }

  def totalHighValueTransactions(transactionList: List[CustomerTransaction]): Double = {
    val getHighValue: PartialFunction[CustomerTransaction, Double] = {
      case x if x.transactionAmount >= 100 => x.transactionAmount
    }
    transactionList
      .collect(getHighValue)
      .foldLeft(0.0)(_ + _)
  }

  def totalHighValueTransactionsFilterMap(transactionList: List[CustomerTransaction]): Double = {
    transactionList
      .filter(_.transactionAmount >= 100)
      .map(_.transactionAmount)
      .foldLeft(0.0)(_ + _)
  }

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C = {
    (a: B, b: A) => f(b, a)
  }

  def sampleList[A](list: List[A]) = {
    list.take(5)
  }

}
