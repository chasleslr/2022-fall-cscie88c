package org.cscie88c.week3

import org.cscie88c.testutils.StandardTest
import org.cscie88c.week3.Student.{
  averageScoreByStudent,
  averageScoreBySubject,
  validateEmail
}

class StudentTest extends StandardTest {
  "Student Management System" when {
    "creating a student" should {
      "have properties - name, email, subject and score" in {
        val student = new Student(
          name = "foo",
          email = "foo@bar.com",
          subject = "baz",
          score = 0
        )
        student.name shouldBe "foo"
        student.email shouldBe "foo@bar.com"
        student.subject shouldBe "baz"
        student.score shouldBe 0
      }
      "validateEmail" should {
        "return true if Student.email contains @" in {
          val student = new Student(
            name = "",
            email = "foo@bar.com",
            subject = "",
            score = 0
          )
          validateEmail(student) shouldBe true
        }
        "return false if Student.email does not contain @" in {
          val student = new Student(
            name = "",
            email = "foo.bar.com",
            subject = "",
            score = 0
          )
          validateEmail(student) shouldBe false
        }
      }
      "averageScoreBySubject" should {
        "return 0 if no students" in {
          averageScoreBySubject("", List()) shouldBe 0.0
        }
        "return 0 if no students match the subject" in {
          val student =
            new Student(name = "", email = "", subject = "foo", score = 100)
          averageScoreBySubject("bar", List(student)) shouldBe 0.0
        }
        "return the average score from students who match the subject" in {
          val student1 =
            new Student(name = "", email = "", subject = "foo", score = 100)
          val student2 =
            new Student(name = "", email = "", subject = "foo", score = 50)
          val student3 =
            new Student(name = "", email = "", subject = "bar", score = 0)
          averageScoreBySubject(
            "foo",
            List(student1, student2, student3)
          ) shouldBe 75.0
        }
      }
      "averageScoreByStudent" should {
        "return 0 if no students" in {
          val student =
            new Student(name = "foo", email = "", subject = "", score = 100)
          averageScoreByStudent(student, List()) shouldBe 0.0
        }
        "return 0 if no students match the student" in {
          val student1 =
            new Student(name = "foo", email = "", subject = "", score = 100)
          val student2 =
            new Student(name = "bar", email = "", subject = "", score = 50)
          averageScoreByStudent(student1, List(student2)) shouldBe 0.0
        }
        "return the average score from all subjects for a given student" in {
          val student1 =
            new Student(name = "foo", email = "", subject = "", score = 100)
          val student2 =
            new Student(name = "foo", email = "", subject = "", score = 50)
          val student3 =
            new Student(name = "bar", email = "", subject = "", score = 0)
          averageScoreByStudent(
            student1,
            List(student1, student2, student3)
          ) shouldBe 75.0
        }
      }
    }
  }
}
