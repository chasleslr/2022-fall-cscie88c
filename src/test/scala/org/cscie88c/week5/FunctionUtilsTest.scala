package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for white" in {
        FunctionUtils.colorToCode("white") shouldBe(255, 255, 255)
      }
      "return the correct value for lime" in {
        FunctionUtils.colorToCode("lime") shouldBe(0, 255, 0)
      }
    }

    "calling fizzBuzzString" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzzString(0) shouldBe "0"
        FunctionUtils.fizzBuzzString(3) shouldBe "Fizz"
        FunctionUtils.fizzBuzzString(4) shouldBe "4"
        FunctionUtils.fizzBuzzString(5) shouldBe "Buzz"
        FunctionUtils.fizzBuzzString(6) shouldBe "Fizz"
        FunctionUtils.fizzBuzzString(15) shouldBe "FizzBuzz"
      }
    }

    "calling fizzBuzz" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzz(6) shouldBe List("1", "2", "Fizz", "4", "Buzz", "Fizz")
      }
    }

    "calling tanDegrees" should {
      "be undefined for values 90 and -90" in {
        FunctionUtils.tanDegrees.isDefinedAt(90) shouldBe false
        FunctionUtils.tanDegrees.isDefinedAt(-90) shouldBe false
      }
      "return the correct value when defined" in {
        FunctionUtils.tanDegrees(0.0) shouldBe 0.0
      }
    }

    "calling totalHighValueTransactions" should {
      "return the sum of transactions greater than 100" in {
        val t1 = CustomerTransaction("1", "", 10.0)
        val t2 = CustomerTransaction("2", "", 100.0)
        val t3 = CustomerTransaction("3", "", 150.0)

        FunctionUtils.totalHighValueTransactions(List()) shouldBe 0.0
        FunctionUtils.totalHighValueTransactions(List(t1)) shouldBe 0.0
        FunctionUtils.totalHighValueTransactions(List(t1, t2)) shouldBe 100.0
        FunctionUtils.totalHighValueTransactions(List(t1, t2, t3)) shouldBe 250.0
      }
    }

    "calling flip2" should {
      "flip the order of arguments of a function" in {
        FunctionUtils.flip2(math.pow)(5, 2) shouldBe 32.0
      }
    }

    "calling sampleList" should {
      "return the first 5 elements of a list" in {
        FunctionUtils.sampleList(List(1, 2, 3, 4, 5, 6, 7)) shouldBe List(1, 2, 3, 4, 5)
        FunctionUtils.sampleList(List("one", "two")) shouldBe List("one", "two")
      }
    }
    // Bonus unit tests
  }

}
