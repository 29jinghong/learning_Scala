package org.programingscala.chapter09
import scala.io.Source


object Chapter09
{
/*Control Abstraction
In this lecture you will make 
9.1 Reducing code duplication

here is 3 ways of matching files
first one is matching the end of the file name.
second one is matching part of the file name.
the third one is matching the the contend entered.

    def filesHere = (new java.io.File(".")).listFiles
    
    def filesEnding(query: String) =
        for (file <- filesHere; if file.getName.endsWith(query))
            yield file

    def filesContaining(query: String) =
        for (file <- filesHere; if file.getName.contains(query))
            yield file

    def filesRegex(query: String) =
        for (file <- filesHere; if file.getName.matches(query))
            yield file

or you can simplyfy the 3 function into the below by useing scala's feature by inputing a function.


    def filesMatching(
        query: String,
        matcher: (String, String) => Boolean
        )=
            for (file <- filesHere; if matcher(file.getName, query))
                yield file

    def filesEnding(query: String) =
        filesMatching(query, _.endsWith(_))
    def filesContaining(query: String) =
        filesMatching(query, _.contains(_))
    def filesRegex(query: String) =
        filesMatching(query, _.matches(_))

*/

    def filesHere = (new java.io.File(".")).listFiles
    
    def filesMatching(matcher: String => Boolean) =
      for (file <- filesHere; if matcher(file.getName))
        yield file
    
    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))
    
    def filesContaining(query: String) =
      filesMatching(_.contains(query))
    
    def filesRegex(query: String) =
      filesMatching(_.matches(query))

/*
9.2 Simplifying client code
*/
    def containsNeg(nums: List[Int]): Boolean = {
        var exists = false
        for (num <- nums)
            if (num < 0)
            exists = true
        exists }

    containsNeg(List(1, 2, 3, 4))
    containsNeg(List(1, 2, -3, 4))
/*
this is a more consist way of writing the code

def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
containsNeg(List(0, -1, -2))
*/

    def containsOdd(nums: List[Int]): Boolean = {
        var exists = false
        for (num <- nums)
            if (num % 2 == 1)
                exists = true
        exists
    }
/*
def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
here is a more consist way of writing the code^
containsOdd(List(1, 2, -3, 4))

9.3 Currying
here is a non curry example:
*/
    def plainOldSum(x: Int, y: Int) = x + y
    plainOldSum(1, 2)

    def curriedSum(x: Int)(y: Int) = x + y

    val fn = curriedSum _

    
/*
he first function invocation takes a single Int parameter named x
and returns a function value for the second function.
This second function takes the Int parameter y.
*/
    def first(x: Int) = (y: Int) => x + y
    
    val second = first(1)

    second(2)

/* 
9.4 Writing new control structures
*/
    def twice(op: Double => Double, x: Double) = op(op(x))
    
    
    def plusFive(x: Double) = x + 5

    val c = twice(plusFive, _)

    def sum2(x: Int)(y: Int): Int = x + y

    // def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    //     val writer = new PrintWriter(file)
    //     try {
    //         op(writer)
    //     } finally {
    //         writer.close()
    //     }
    // }

    // withPrintWriter(
    // new File("date.txt"),
    // writer => writer.println(new java.util.Date)
    // )
/*
println("Hello, world!")
println { "Hello, world!" }
both of the above print works but the curly bracket one only work with one argument

9.5 By-name parameters
*/

    var assertionsEnabled = true
    def myAssert(predicate: () => Boolean) =
        if (assertionsEnabled && !predicate())
            throw new AssertionError

    myAssert(() => 5 > 3)
/*
    myAssert(5 > 3)

    def byNameAssert(predicate: => Boolean) =
        if (assertionsEnabled && !predicate)
            throw new AssertionError
*/
}