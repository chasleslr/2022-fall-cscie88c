package org.cscie88c.week4

import org.cscie88c.testutils.StandardTest
import org.scalactic.TolerantNumerics

class TrigUtilsTest extends StandardTest {

  val epsilon = 1e-4f

  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(epsilon)

  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 90" in {
        assert(TrigUtils.sinDegrees(90 * math.Pi / 180) === 1.0)
      }
      "return the correct value for 0" in {
        TrigUtils.sinDegrees(0) shouldBe 0.0
      }
    }
    "calling cos" should {
      "return the correct value for 90" in {
        assert(TrigUtils.cosDegrees(90 * math.Pi / 180) === 0.0)
      }
      "return the correct value for 0" in {
        TrigUtils.cosDegrees(0) shouldBe 1.0
      }
    }
  }

  "calling squared" should {
    "return the correct value for 1" in {
      TrigUtils.squared(1) shouldBe 1
    }
    "return the correct value for 5" in {
      TrigUtils.squared(5) shouldBe 25
    }
  }
}
