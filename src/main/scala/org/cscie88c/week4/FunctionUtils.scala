package org.cscie88c.week4

object FunctionUtils {
  
  // complete the implementation of the higher order functions below
  def applyNtimes(n: Int)(x: Int)(f: Int => Int): Int = {
    var result: Int = x
    for (i <- 1 to n) {
      result = f(result)
    }
    result
  }

  def myPositivePower(x: Int, n: Int): Int = {
    applyNtimes(n - 1)(x)((c) => c * x)
  }

  def deferredExecutor(name: String)(f: Int => Int): Int => Int = {
    (x: Int) => {
      println("running on deferredExecutor " + name + " with value " + x)
      f(x)
    }
  }
}
