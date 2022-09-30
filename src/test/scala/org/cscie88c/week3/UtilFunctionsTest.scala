package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }

class UtilFunctionsTest extends StandardTest {
  "UtilFunctions" when {
    "with PythTest" should {
      "return true if Pythagorean triplet" in {
        UtilFunctions.pythTest(3, 4, 5) shouldBe true
      }
      "return false if not Pythagorean triplet" in {
        UtilFunctions.pythTest(1, 1, 1) shouldBe false
      }
    }
    "with pythTriplesUpto100" should {
      "verify elements in list are pythagorean triples" in {
        UtilFunctions
          .pythTriplesUpto100
          .forall(t => UtilFunctions.pythTest(t._1, t._2, t._3)) shouldBe true
      }
    }
  }
}
