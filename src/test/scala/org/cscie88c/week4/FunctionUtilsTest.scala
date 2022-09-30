package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class FunctionUtilsTest extends StandardTest {

  def add5(x: Int) = x + 5
  "FunctionUtils" when {
    "calling applyNtimes" should {
      "return the correct value" in {
        FunctionUtils.applyNtimes(3)(0)(add5) shouldBe 15
        FunctionUtils.applyNtimes(1)(1)(add5) shouldBe 6
        FunctionUtils.applyNtimes(2)(1)(add5) shouldBe 11
      }
    }
     "calling myPositivePower" should {
       "return the correct value" in {
         FunctionUtils.myPositivePower(1, 1) shouldBe 1
         FunctionUtils.myPositivePower(2, 2) shouldBe 4
         FunctionUtils.myPositivePower(3, 3) shouldBe 27

       }
     }
     "calling deferredExecutor" should {
       "return the correct value" in {
         val myDeferredFunction = FunctionUtils.deferredExecutor("CPU Pool")(add5)
         myDeferredFunction(4)
       }
     }
  }
 
}
