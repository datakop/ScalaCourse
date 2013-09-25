package recfun
import common._
import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def isOnEdge(c: Int, r: => Int) : Boolean = ( (c == 0) || (c == r) ) 

    if (isOnEdge(c, r)) 1
    else (pascal(c-1, r-1) + pascal(c, r-1)) 
}


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isBalansed(x: Int): Boolean = (x == 0)
    def guard(x: Int, xs: List[Char]): Boolean = ((x < 0) || xs.isEmpty)
    
    def loop(acc: Int, xs: List[Char]): Boolean = 
      if (guard(acc, xs)) isBalansed(acc)
      else (if (xs.head == '(') loop(acc + 1, xs.tail) 
    		  else (if (xs.head == ')') loop(acc - 1, xs.tail)
    		  			else loop(acc, xs.tail)
		  			)
  			)
    
    if (chars.isEmpty) true
    else loop(0, chars)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def f(lastMaxCoin_total_coll: List[(Int, Int)], count: Int): Int = {
      if (lastMaxCoin_total_coll.isEmpty) {
        count
      } else {
        val b = ListBuffer[(Int, Int)]()
        var newCount = count
        for ((lastMaxCoin, total) <- lastMaxCoin_total_coll) {
          if (total < money) {
            for (c <- coins) {
              if (c >= lastMaxCoin) {
                val e = (c, total + c)
                b += e
              }
            }
          } else if (total == money) {
            newCount += 1
          }
        }
 
        f(b.toList, newCount)
      }
    }
 
    val b = coins.map { c => (c, c) }
    f(b, 0)
  }
}
