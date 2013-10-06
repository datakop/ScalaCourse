package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s0 = singletonSet(0)
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    
    val u0 = union(union(s1, s2), s3)
    val u1 = union(u0, s0)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  
  test("intersect contains only same elements") {
    new TestSets {
      val s = intersect(union(s1, s2), s1)
      
      assert(contains(s, 1), "intersect 1")
      assert(!contains(s, 2), "intersect 2")
      assert(!contains(s, 3), "intersect 3")
    }
  }
  
  test("diff test") {
    new TestSets {
      val s = diff(union(s1, s2), s1)
      
      assert(!contains(s, 1), "diff 1")
      assert(contains(s, 2), "diff 2")
      assert(!contains(s, 3), "diff 3")
    }
  }
  
  test("filter {1, 2, 3} by x>1") {
    new TestSets {
      val s = filter(union(union(s1, s2), s3), (x: Int) => x > 1)
      
      assert(!contains(s, 1), "filter 1")
      assert(contains(s, 2), "filter 2")
      assert(contains(s, 3), "filter 3")
    }
  }
  
  test("forall u0 and u1 x>=1") {
    new TestSets {
      val r0 = forall(u0, (x: Int) => x >= 1)
      val r1 = forall(u1, (x: Int) => x >= 1)
      assert(r0 === true, "forall 0")
      assert(r1 === false, "forall 1")
    }
  }
  

  test("exists u0 and u1 x==0") {
    new TestSets {
      val r0 = exists(u0, (x: Int) => x == 0)
      val r1 = exists(u1, (x: Int) => x == 1)
      assert(r0 === false, "exists 0")
      assert(r1 === true, "exists 1")
    }
  }

  test("map u0 with x*x") {
    new TestSets {
      val r0 = map(u0, (x: Int) => x*x )


      assert(contains(r0, 1), "contains 1*1")
      assert(contains(r0, 4), "contains 2*2")
      assert(contains(r0, 9), "contains 3*3")
      assert(!contains(r0, 2), "not contains 2")
      assert(!contains(r0, 3), "not contains 3")
    }
  }

  
  
}
