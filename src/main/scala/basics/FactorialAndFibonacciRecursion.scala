package basics

class FactorialAndFibonacciRecursion {
  def fact(n: Int): Int = {
    var result = 0
    if(n > 0) {  
      result = n*fact(n-1)
    }
    else {
      n
    }
    result
  }
  def fib(n: Int): Int = {
    fib(n-1)+fib(n-1)
  }
}