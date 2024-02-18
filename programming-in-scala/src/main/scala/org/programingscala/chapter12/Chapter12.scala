package org.programingscala.chapter12
import scala.io.Source
import scala.language.postfixOps
//this is for dot notation

import scala.collection.mutable.ArrayBuffer


object Chapter12
{
/* 
Traits
Traits are used to share interfaces and fields between classes they are very useful as generic types and with abstract methods.

12.1 How traits work

widening thin interfaces to rich ones
and defining stackable modifications.


    trait Printable {
        def show(): Unit = {
            println(this)
        } 
    }
this declears a trait named printable and
sice it dident declear a superclass it have a defalt superclass of AnyRef 
    
    class Fish extends AnyRef with Printable {
        override def toString = "a fish"
    }

    val fish = new Fish

    fish.show()
A trait is also usable as a type.
    val pr: Printable = fish
for pr the type is Printable and any inheriting will be stored into pr including Frogs*/

/* and since both Frog and Printable extends AnyRef you can do a short cut like this
    class Fish extends Printable{
        override def toString = "a fish"
    }
altho class and trait works roughly the same you cant have parameters in traits
like this:
    trait NoPoint(x: Int, y: Int) {}

you can give trait super but it will only be called when the trait get mixed into a concrete class

a class can have any number of traits.
    class Swim
    trait waterbreath
    class Fish extends Swim with waterbreath {}

12.2 Thin versus rich interfaces

traits can enrich thin interface into a rich interface
rich interface have many methods
thin interface is easyer on implementing
concrete methods will tilt thin vs rich toward the rich side

12.3 Example: Rectangular objects

*/
/*
    class Point(val x: Int, val y: Int )
    class Rectangle(val topLeft: Point,val bottomRight: Point){
        def left = topLeft x 
        def right = bottomRight x
        def width = right - left 
    }
*/
/*this is what we are going to talk about^*/

    class Point(val x: Int, val y: Int )
    //class Point(x:Int,y:Int){val x = x; val y = y }
    trait Rectangular{
        val topLeft: Point 
        val bottomRight: Point

        def left = topLeft.x
        def right = bottomRight.x 
        def width = right - left 
    }
    
    abstract class Component extends Rectangular {
    }

    class Rectangle(val topLeft: Point, val bottomRight: Point)
    extends Rectangular {
    }


    val rect = new Rectangle(new Point(1,1), new Point(10,10))


/*
12.4 The standard Ordered trait
a really good example of thin interface of comparasen is <= vs x < y || x == y
in scala traits allow you to implement one comparson and then inrich it.

the ordersed trait helps you write in comparsons much more easy
you can simplyfy from this:

inal class Rational(n: Int, d: Int) {
    // ...
    def <(that: Rational) =
      this.numer*that.denom > that.numer*this.denom
    def >(that: Rational) = that < this
    def <=(that: Rational) = (this < that) || (this == that)
    def >=(that: Rational) = (this > that) || (this == that)
}

to:

final class Rational(n: Int, d: Int)
    extends Ordered[Rational]
    {
// ...
    def compare(that: Rational) =
        this.numer*that.denom - that.numer*this.denom
    }

    when you extend Ordered you would have to extend Ordered[C]
    C is the class you want to compaire elements
    in this senerial you would want to put in rational because rational is the class you compaire
    next you need to define the compare method which compares this with the passed in argunment that.
    should return a 0 if the object is the same or a negitive if the object is less, and a positive if the object is greterthan.

    which looks like this

    val half = new Rational(1,2)
    this.numer(1)
    this.denom(2)

    val third = new Rational(1,3)
    that.numer(1)
    that.denom(3)

    half > third
    
    this.numer*that.denom - that.numer*this.denom
    (1*3) - (1*2)
    3 - 2 = 1
    return = true

    12.5 Traits as stackable modifications

    traits can let you modify methods of a class
    and stackable
*/    

/*
    abstract class IntQueue {
        def get(): Int
        def put(x: Int)
    }

    class StandardQueue extends IntQueue {
        private val buf = new ArrayBuffer[Int]
        def get() = buf.remove(0)
        def put(x: Int) = buf += x
    }

    trait Doubling extends IntQueue {
        abstract override def put(x: Int) = super.put(2 * x)
    }
    
    val queue = new StandardQueue with Doubling
    /*this is useable because both Doubling and StandardQueue extends IntQueue*/

*/
/*this part of code says it don't work^ what do i need to search up to fix this?*/

/*abstract override is when the orgin class is a abstract class*/
/*
12.6 Why not multiple inheritance?
talks about the best way to line up things and how multiple traits effect super

12.7 To trait, or not to trait?
3 simple consept to remember:

1. If the behavior will not be reused, then make it a concrete class.

2. If it might be reused in multiple, unrelated classes, then make it a trait.

3.If you want to inherit it in Java code, then use an abstract class.
*/
    abstract class human{
        val age = 21
        def eat()
        def sleep()
    }
    class normalES extends human{
        def eat(): Unit = {
            print(s"at a age of $age is best to eat 5 punds a day")
        }
        def sleep(): Unit = {
            print(s"sleeping time for $age is best to be 7 hr")
        }
    }

    trait jinghongES extends human{
        abstract override def eat(): Unit = {
            print(s"at a age of $age is best to eat 10 punds a day")
        }
        abstract override def sleep(): Unit = {
            print(s"sleeping time for $age is best to be 12 hr")
        }
    }
    class fat extends normalES with jinghongES
    var jinghong = new fat



    trait SayHi{
        def hi(): Unit = {
            println("Hi!")
        }
        def hi2(): Unit 
    }

    class Person(val name: String, val age : Int) extends SayHi{
        def greeting(): Unit = {
            println(s"hi my name is $name, and my age is $age.")
        }

        def hi2(): Unit = {
            println("Hi2!")
        }
    }

    val jingyong = new Person("jingyong", 14)
}
