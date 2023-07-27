
# Chapter 1 (pg29)

## A Scalable Language
---
Scala is an acoronym for scalable language

it is statically typed 
> statically typed - have type for varible stored, and can't be changed
it is also functional and object oriented

Scala is really good with fusion functional and object oriented 

## Object Oriented Programing
---

all but the most trivial programs need some sort of structure.

>trivial - something common 

For instance, many languages admit values that are not objects, such as the primitive values in Java
(The eight primitives defined in Java are int, byte, short, long, float, double, boolean and char)

### Functional programming
---

Functional programming is guided by two main ideas.

1) Functions are first-class values.

* In a functional language, a function is a value of the same status as
, say, an integer or a string. 
You can pass functions as arguments to other functions
, return them as results from functions, or store them in variables.
You can also define a function inside another function
, just as you can define an integer value inside a function.

2) The operations of a program should map input values to output values 
rather than change data in place.

* Another way of stating this second idea of functional programming.
is that methods should not have any side effects

* Immutable data structures are one of the cornerstones of functional programming.
Scala has immutable lists, tuples, maps, and sets. Which Java don't have.
Methods like that is called **referentially transparent**

* **Imperative style** is what programming with mutable data and side effects is called

in Scala a function value is an object(pg35)

object is basicaly a instance of a class
in order to create a object you would need a instance of some kind of class

here is some example:

```scala
def test(x: Int)(y: Int): Int = x + y
def testTwo(x: Int)(y: Int): Int = x * y

val addOne: Int => Int = test(1) _
val addTwo: Function1[Int, Int] = test(2) _
//function curry

List(1, 2, 3).map(addTwo)
List(1, 2, 3).map(i => i + 2)
```

method implementation(pg36)

on the left side of the equal sign for def is the method signature
and on the right is the method implementation

name-less function literals & 
first-class nested functions (pg37)

>name less functions - are also called anonymous function

>first class - can pass into a function as a value

### SBT
---

Is an open source build tool for Scala and Java projects
is used to compile and run Scala