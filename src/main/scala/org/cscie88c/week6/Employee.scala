package org.cscie88c.week6

final case class Employee(name: String, age: Int, salary: Int)

object Employee {

  implicit val employeeOrdering: Ordering[Employee] = new Ordering[Employee] {
    override def compare(x: Employee, y: Employee): Int = {
      x.name.compareTo(y.name)
    }
  }

  def defaultSortEmployees(employees: List[Employee]): List[Employee] = employees.sorted

  def sortEmployeesBySalary(employees: List[Employee]): List[Employee] = {
    val orderingBySalary: Ordering[Employee] = Ordering.by[Employee, Int](_.salary)
    employees.sorted(orderingBySalary)
  }
  
}
