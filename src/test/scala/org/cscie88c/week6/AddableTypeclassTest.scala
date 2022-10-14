package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class AddableTypeclassTest extends StandardTest {
  
  "AddableAggregator" should {
    "sum a list of integers" in {
      AddableAggregator.sumWithAddable(List(1, 2, 3)) shouldBe 6
    }
    "sum a list of booleans" in {
      AddableAggregator.sumWithAddable(List(true, false)) shouldBe true
    }
    "sum a list of employees" in {
      AddableAggregator.sumWithAddable(
        List(
          Employee("ken", 25, 80000),
          Employee("burns", 35, 90000),
        )
      ) shouldBe Employee("ken,burns", 60, 170000)
    }
  }
}
