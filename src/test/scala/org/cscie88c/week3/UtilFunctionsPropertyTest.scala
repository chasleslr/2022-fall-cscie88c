package org.cscie88c.week3

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class UtilFunctionsPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val triplesGen: Gen[(Int, Int, Int)] =
    Gen.oneOf(UtilFunctions.pythTriplesUpto100)

  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }

  test("mult2 distributive test") {
    forAll { (a: Int, b: Int, c: Int) =>
      UtilFunctions.mult2(a, (b + c)) == UtilFunctions.mult2(
        a,
        b
      ) + UtilFunctions.mult2(a, c)
    }
  }

  test(
    "If (x, y, z) is a pythagorean triple, then (y, x, z) is also a pythagorean triple"
  ) {
    forAll(triplesGen) { (triples: (Int, Int, Int)) =>
      UtilFunctions.pythTest(
        triples._1,
        triples._2,
        triples._3
      ) == UtilFunctions.pythTest(triples._2, triples._1, triples._3)
    }
  }

  test("If (x, y, z) is a pythagorean triple, then (2y, 2x, 2z) is also a pythagorean triple") {
    forAll(triplesGen) { (triples: (Int, Int, Int)) =>
      UtilFunctions.pythTest(2*triples._1, 2*triples._2, 2*triples._3) shouldBe true
    }
  }

}
