package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class EmployeeTest extends StandardTest {
  "Employee" should {
    val e1 = Employee("foo", 10, 100)
    val e2 = Employee("bar", 10, 200)
    val e3 = Employee("baz", 10, 300)
    val employees = List(e1, e2, e3)
 
    "have a default sort order" in {
      Employee.defaultSortEmployees(employees) shouldBe List(e2, e3, e1)
    }

    "sort employees by salary" in {
      Employee.sortEmployeesBySalary(employees) shouldBe List(e1, e2, e3)
    }
  }
}
