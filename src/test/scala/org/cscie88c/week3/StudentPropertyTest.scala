package org.cscie88c.week3
import org.cscie88c.week3.Student.averageScoreBySubject
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class StudentPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val studentGen: Gen[Student] = for {
    name <- Gen.oneOf("foo", "bar", "baz")
    email <- Gen.stringOf(Gen.alphaChar)
    subject <- Gen.stringOf(Gen.alphaChar)
    score <- Gen.chooseNum(0, 100)
  } yield Student(name, email, subject, score)

   val studentListGen: Gen[List[Student]] = Gen.listOf(studentGen)

  test("description contains name and email") {
    forAll(studentGen) { (student: Student) =>
      student.description contains student.name shouldBe true
      student.description contains student.email shouldBe true
    }
  }

  test("averageScoreBySubject < 100 for Math") {
    forAll(studentListGen) { (students: List[Student]) =>
      assert(averageScoreBySubject("Math", students) < 100)
    }
  }

}
