package org.cscie88c.week7

import scala.concurrent.{Future}
import scala.util.{Try, Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.collection.parallel.CollectionConverters._

object FutureUtils {
  
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = Future {
    rnd.between(300, 800)
  }

  def printCreditScore(applicantId: Int): Unit =
    creditScoreAPI(applicantId).onComplete {
      case Success(score) => println(s"The credit score for ${applicantId} is ${score}")
      case Failure(e) => println(s"Cannot get credit score for ${applicantId} at this time")
    }

  def passedCreditCheck(applicantId: Int): Future[Boolean] = {
    creditScoreAPI(applicantId).map(x => x >= 600)
  }

  def futureFactorial(n: Int): Future[Int] = Future {
    (1 to n).foldLeft(1)(_ * _)
  }

  def futurePermuations(n: Int, r: Int): Future[Int] = {
    for {
      a <- futureFactorial(n)
      b <- futureFactorial(n - r)
    } yield {a / b}
  }

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = {
//    Future.traverse(idList) { id => creditScoreAPI(id)}
//    idList.map(x => creditScoreAPI(x))
    ???
  }

  def slowMultiplication(x: Long, y: Long): Long = {
    Thread.sleep(1000)
    x * y
  }

  def concurrentFactorial(n: Long): Long = ???

  def sequentialFactorial(n: Long): Long = {
//    (1 to n).foldLeft(1.toLong)(slowMultiplication(_, _))
    ???
  }

}
