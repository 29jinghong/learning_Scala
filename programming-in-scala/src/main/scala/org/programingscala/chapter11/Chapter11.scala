package org.programingscala.chapter11
import scala.io.Source

object Chapter09
{
    /* 
    11.1 Scala’s class hierarchy

    Because every class inherits from Any,
    every object in a Scala program can be compared using ‘==’, ‘!=’, or equals;
    hashed using hashCode; and formatted using toString.
    The equality and inequality methods, ‘==’ and ‘!=’, are declared final in class Any,
    so they cannot be overridden in subclasses. In fact, ‘==’ is always the same as equals and
    ‘!=’ is always the negation of equals.
    
    So individual classes can tailor what ‘==’
    or ‘!=’ means by overriding the equals method.
   
    11.2 How primitives are implemented
    in java if you == two variables they are set equal based on the path stored not the actual value
    in scala if you define a defalt class it works the same with java but if you define a case class
    it will check the stored value insted of the path.


    11.3 Bottom types
    Type Nothing is at the very bottom of Scala’s class hierarchy.
    Then is type null.
    
    class Null is not in the null reference it is a subclass of every reference class so you cannot assign
    it to a value.

    - class null is a subclass for every reference class.
    
    the return type of error is Nothing and noting is a subtype for every other type
    so you can do the following for example
    
    */
    def error(message: String): Nothing =
        throw new RuntimeException(message)
    //you can have nothing as your return type

    def divide(x: Int, y: Int): Int =
        if (y != 0) x / y
        else error("can't divide by zero")

    // you can also have error as a return in any function such as the above one 
    //since error is type Nothing and Nothing is a sub type of every type it would satisfy the
    //condition of return type int.

    val x = "abcd".substring(2)
    val y = "abcd".substring(2)

    val answer:Boolean = x == y
}
