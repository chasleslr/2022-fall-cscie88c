package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import Streams.Dog

class StreamsTest extends StandardTest {

  "calling healthyDogs" should {
    "only return healthy dogs" in {
      val d = Streams.dogs.take(5)
      Streams.healthyDogs(d).forall(_.hasCurrentShots == true) shouldBe true
    }
  }

  "calling averageHealthyAge" should {
    "return the average of healthy dogs" in {
      val d = Streams.dogs.take(5)
      val avg = d.filter(_.hasCurrentShots == true).map(_.age).sum / 5.0

      Streams.averageHealthyAge(d, 5) shouldBe avg
    }
  }
}
