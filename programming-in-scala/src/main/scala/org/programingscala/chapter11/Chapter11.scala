package org.programingscala.chapter09
import scala.io.Source

object Chapter09
{
    /* 
    11.1 Scala’s class hierarchy
    At the top of the hierarchy is class Any
    Because every class inherits from Any, every object in a Scala program
    can be compared using ‘==’, ‘!=’, or equals; hashed using hashCode;
    and for- matted using toString.
   
    11.2 How primitives are implemented
    reference type, the result is false. This is one aspect where it shows that Java
    is not a pure object-oriented language.
    There is a difference between primitive types and reference types that can be clearly observed.
    Let’s repeat the same experiment in Scala:
    the equality operation == in Scala is designed to be transparent
    with respect to the type’s representation.

    11.3 Bottom types
    Type Nothing is at the very bottom of Scala’s class hierarchy.
    One use of Nothing is that it signals abnormal termination. For instance there’s
    the error method in the Predef object of Scala’s standard library
    he return type of error is Nothing, which tells users that the
    method will not return normally
    */
    val x = "abcd".substring(2)
    val y = "abcd".substring(2)
    val answer:Boolean = x == y
}