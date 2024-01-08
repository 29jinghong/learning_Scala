package org.programingscala.chapter12
import scala.io.Source

object Chapter12
{
/* 
Traits
12.1 How traits work

 */

    trait Printable {
        def show(): Unit = {
            println(this)
        } 
    }

    class Frog extends AnyRef with Printable {
        override def toString = "a frog"
    }

    val frog = new Frog

    frog.show()
}