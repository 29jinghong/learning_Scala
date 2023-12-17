package org.programingscala.chapter10
import scala.io.Source


object Chapter10
{
/*
Chapter 10
Composition and Inheritance

10.1 A two-dimensional layout library

    val column1 = elem("hello") above elem("***")
    val column2 = elem("***") above elem("world")
    print(column1 beside column2)

result will be:

hello ***
*** world
combinators- combine elements of some domain into new elements.

10.2 Abstract classes

The abstract modifier signifies that the class may have abstract members
that do not have an implementation.


The abstract methods of abstract class are those methods which do not
contain any implementation. Or in other words, the method which does not
contain body is known as an abstract method.

so if you write 
    scala> absract class Element
    scala> new Element
    <console>:5: error: class Element is abstract; cannot be instantiated
new Element

10.3 Defining parameterless methods

    abstract class Element {
        def contents: Array[String]

        def width: Int =
            if (height == 0) 0 else contents(0).length

        def height: Int = contents.length
    }

10.4 Extending classes
since you cant instantiate an element on the class Element
you would need to crate a sub class for that

    // class ArrayElement(conts: Array[String]) extends Element {
    //      def contents: Array[String] = conts
    // }
    
    class ArrayElement(val contents: Array[String]) extends Element

   
    val ae = new ArrayElement(Array("hello", "world"))


10.5 Overriding methods and fields
values (fields, methods, packages, and singleton objects)
types (class and trait names)

10.6 Defining parametric fields


    // class ArrayElement(x123: Array[String]) extends Element {
    //     val contents: Array[String] = x123
    // }
//You can also prefix a class parameter with var, in which case the
//corresponding field would be reassignable.

    class Cat {
        val dangerous = false
    }
    class Tiger(param1: Boolean, param2: Int) extends Cat {
        override val dangerous = param1
        private var age = param2
    }

10.7 Invoking superclass constructors

One important aspect of object-oriented pro- gramming is that it makes it easy to extend
a system with new data-variants. You can simply add subclasses.

    

    class LineElement(s: String) extends ArrayElement(Array(s)) {
        override def width = s.length
        override def height = 1
    }

to extend a class you would use the key word extends like following

    extends ArrayElement(Array(s))

10.8 Using Override modifiers


10.9 Polymorphism and dynamic binding

You can create even more forms of Element by defining new Element subclasses

    class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
    ) extends Element {
        private val line: String = ch.toString * width
        def contents: Array[String] = Array.fill(height)(line)
    }

     
    abstract class Element {
        def demo(): Unit = {
            println("Element's implementation invoked")
        }
    }
  
    class ArrayElement extends Element {
        override def demo(): Unit = {
            println("ArrayElement's implementation invoked")
        }
    }
    
    class LineElement extends ArrayElement {
        override def demo(): Unit = {
            println("LineElement's implementation invoked")
        }
    }

    class UniformElement extends Element

    def invokeDemo(e: Element): Unit = {
        e.demo()
    }

10.10 Declaring final members

here is a way to declar final class 
in a final class you can not decear a sub class any more

final class ArrayElement extends Element {
                 override def demo() {
                   println("ArrayElement's implementation invoked")
                 }
}

10.11 Using composition and inheritance

since all declration of LineElement extending Element is all for the definition of content
its better to just defin LineElement as a direct subclass for Element


    class LineElement(s: String) extends Element{
         val contents: Array[String] = Array(s)
         override def width = s.length
         override def height = 1
    }


10.12 Implementing above, beside, and toString




    def above(that: Element): Element =
        new ArrayElement(this.contents ++ that.contents)


The ‘++’ operation concatenates two arrays.
for now will only pass in the same lenth of array



    def beside(that: Element): Element = {
        val contents = new Array[String](this.contents.length)
        for (i <- 0 until this.contents.length)
            contents(i) = this.contents(i) + that.contents(i)
        new ArrayElement(contents)
    }


    new ArrayElement(
        for ((line1, line2) <- this.contents zip that.contents)
            yield line1 + line2
    )

    in the method above the code would zip(transformed into an array of pairs)
    
    if you would oprate
    Array(1, 2, 3) zip Array("a", "b")
    
    it will return:
    Array((1, "a"), (2, "b"))
    If one of the two operand arrays is longer than the other,
    zip will drop the remaining elements.
    


    override def toString = contents mkString "\n"

    this line of code will to string all the paired content to a single string element
    and also will seprate each 


    abstract class Element {
    def contents: Array[String]
    def width: Int =
      if (height == 0) 0 else contents(0).length
    def height: Int = contents.length
    def above(that: Element): Element =
      new ArrayElement(this.contents ++ that.contents)
    def beside(that: Element): Element =
      new ArrayElement(
        for ((line1, line2) <- this.contents zip that.contents)
          yield line1 + line2
)
override def toString = contents mkString "\n" }

object Element {
    def elem(contents:  Array[String]): Element =
        new ArrayElement(contents)
    
    def elem(chr: Char, width: Int, height: Int): Element =
        new UniformElement(chr, width, height)
    
    def elem(line: String): Element =
        new LineElement(line)
}

    import Element.elem
    abstract class Element {
        def contents: Array[String]
        def width: Int =
            if (height == 0) 0 else contents(0).length
        def height: Int = contents.length
        def above(that: Element): Element =
            elem(this.contents ++ that.contents)
        def beside(that: Element): Element =
            elem(
                for ((line1, line2) <- this.contents zip that.contents)
                    yield line1 + line2
)
override def toString = contents mkString "\n" }


10.13 Defining a factory object

A factory object contains methods that construct other objects.
An advantage of this approach is that object creation can be centralized
and the details of how objects are represented with classes can be hidden.

10.14 Putting it all together


*/


    import Element.elem
    abstract class Element {
        def contents: Array[String]
        def width: Int =
            if (height == 0) 0 else contents(0).length
        def height: Int = contents.length
        def above(that: Element): Element =
            elem(this.contents ++ that.contents)
        def beside(that: Element): Element =
            elem(
                for ((line1, line2) <- this.contents zip that.contents)
                yield line1 + line2
            )

        object Element {
            private class ArrayElement(val contents: Array[String]) extends Element
            
            private class LineElement(s: String) extends Element {
                val contents: Array[String] = Array(s)
                override def width: Int = s.length
                override def height: Int = 1
            }
            
            private class UniformElement(
                ch: Char,
                override val width: Int,
                override val height: Int
                ) extends Element {
                    private val line = ch.toString * width
                    def contents = Array.make(height, line)
                }
                def elem(contents:  Array[String]): Element =
                    new ArrayElement(contents)
                def elem(chr: Char, width: Int, height: Int): Element =
                    new UniformElement(chr, width, height)
                def elem(line: String): Element =
                    new LineElement(line)
            }

        import Element.elem
        object Spiral {
            val space = elem(" ")
            val corner = elem("+")
            def spiral(nedges: Int, direction: Int): Element = {
                if (nedges == 1)
                    elem("+")
                else {
                    val sp = spiral(nedges - 1, (direction + 3) % 4) 
                    def verticalBar = elem('|', 1, sp.height)
                    def horizontalBar = elem('-', sp.width, 1)
                    
                    if (direction == 0)
                        (corner beside horizontalBar) above (sp beside space)
                    else if (direction == 1)
                        (sp above space) beside (corner above verticalBar)
                    else if (direction == 2)
                        (space beside sp) above (horizontalBar beside corner)
                    else
                        (verticalBar above corner) beside (space above sp)
                }
            }

            def main(args: Array[String]): Unit = {
                val errMsg = "Please enter integer number of sides"
                val output =
                if (args.length == 0)
                    errMsg
                else try {
                    val nSides = args(0).toInt
                    if (nSides < 1)
                        "Please enter integer greater than zero"
                    else
                        spiral(nSides, 0)
                    }
                catch {
                    case e: NumberFormatException => errMsg
                    }

                println(output)
                } 
            }

        }
}