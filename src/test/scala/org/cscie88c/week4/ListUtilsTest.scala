package org.cscie88c.week4

import org.cscie88c.testutils.StandardTest


class ListUtilsTest extends StandardTest {
  "ListUtils" when {
    "calling ones" should {
      "return the correct value" in {
        ListUtils.ones(5).forall(_ == 1.0) shouldBe true
      }
    }
    "calling zeroes" should {
      "return the correct value" in {
        ListUtils.zeros(5).forall(_ == 0.0) shouldBe true
      }
    }
    "calling charCounts" should {
      "return the correct value" in {
        ListUtils.charCounts("Hello world") shouldBe
          Map('e' -> 1, 'l' -> 3, 'H' -> 1, 'w' -> 1, 'r' -> 1, 'o' -> 2, 'd' -> 1)
      }
      "panagram" in {
        val alphabet = "abcdefghijklmnopqrstuvwxyz".toList
        val panagram = ListUtils.charCounts("The quick brown fox jumps over the lazy dog")
        alphabet.forall(panagram.keySet.contains(_)) shouldBe true
      }
    }
    "calling topN" should {
      "return the top nresults in a map" in {
        val frequencies = Map('a' -> 2, 'b' -> 4, 'c' -> 5)
        ListUtils.topN(2)(frequencies) shouldBe Map('c' -> 5, 'b' -> 4)
      }
    }
  }
}
