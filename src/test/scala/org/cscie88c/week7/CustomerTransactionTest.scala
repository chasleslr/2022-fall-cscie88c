package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "load and clean raw CSV data file" in {
      CustomerTransaction.apply("id1,customer-A,84.5") shouldBe
        Some(CustomerTransaction("id1", "customer-A", 84.5))
    }
    "return None when CSV is invalid" in {
      CustomerTransaction.apply("id1,customer") shouldBe None
    }
    "read records from a CSV valid, ignoring invalid records" in {
      assert(CustomerTransaction.readFromCSVFile("data/dirty-retail-data-sample.csv").size >= 5)
    }
  }
}
