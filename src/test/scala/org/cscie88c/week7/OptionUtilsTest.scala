package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class OptionUtilsTest extends StandardTest {
  val fileName = "data/dirty-retail-data-sample.csv"
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        OptionUtils.fileCharCount(fileName) shouldBe Success(195)
      }
      "return a Failure when an invalid file" in {
        OptionUtils.fileCharCount("data/invalid") shouldBe a [Failure[Long]]
      }
    }
    "calling charCountString" should {
      "return the correct string with character count for a valid file" in {
        OptionUtils.charCountAsString(fileName) shouldBe "number of characters: 195"
      }
      "return the correct string for an invalid file" in {
        OptionUtils.charCountAsString("data/invalid") shouldBe "error opening file"
      }
    }
  }

}
