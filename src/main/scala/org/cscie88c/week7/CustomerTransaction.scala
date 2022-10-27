package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

final case class CustomerTransaction(
  customerId: String,
  transactionDate: String,
  transactionAmount: Double
)

object CustomerTransaction {
  def apply(csvString: String): Option[CustomerTransaction] = Try {
    val Array(id, date, amount) = csvString.split(",")
    CustomerTransaction(id, date, amount.toDouble)
  }.toOption

  def readFromCSVFile(fileName: String): List[CustomerTransaction] = {
    Source
      .fromResource(fileName)
      .getLines()
      .map(CustomerTransaction(_))
      .collect { case Some(c) => c}
      .toList
  }
}
