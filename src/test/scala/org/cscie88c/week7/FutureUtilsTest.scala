package org.cscie88c.week7

import org.cscie88c.testutils.{FuturesTest}
import scala.concurrent.Future

import org.scalatest.flatspec._
import org.scalatest.matchers.should._

class FutureUtilsTest extends FuturesTest with Matchers {
  
  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling creditScoreAPI" should {
      "return a credit score greater than 300" in {
        FutureUtils.creditScoreAPI(1).map { x => x should (be >= 300 and be <= 800)}
      }
    }
    "calling futureFactorial" should {
      "return the correct value" in {
        FutureUtils.futureFactorial(4).map { x => x shouldBe 24}
      }
    }
    "calling futurePermutations" should {
      "return the correct value" in {
        FutureUtils.futurePermuations(4, 2).map(x => x shouldBe 12)
      }
    }
  }
}
