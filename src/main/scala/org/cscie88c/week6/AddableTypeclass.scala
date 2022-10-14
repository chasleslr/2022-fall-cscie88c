package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  def addTwoValues(a: A, b: A): A
}

object AddableTypeclass {
  
  implicit val intAddableTypeclass: AddableTypeclass[Int] = new AddableTypeclass[Int] {
    override def addTwoValues(a: Int, b: Int): Int = a + b
  }

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] = new AddableTypeclass[Boolean] {
    override def addTwoValues(a: Boolean, b: Boolean): Boolean = {
      if (a | b) true else false
    }
  }

  implicit val employeeAddableTypeclass: AddableTypeclass[Employee] = new AddableTypeclass[Employee] {
    override def addTwoValues(a: Employee, b: Employee): Employee = {
      Employee(s"${a.name},${b.name}", a.age + b.age, a.salary + b.salary)
    }
  }

}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A = {
    list.reduce(addable.addTwoValues(_, _))
  }
}
