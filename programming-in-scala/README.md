Scala 
===

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

### SBT
---

Is an open source build tool for Scala and Java projects
is used to compile and run Scala

# Chapter 2 (pg48)

## First Steps in Scala
---
Data types: 

>Bit - (a bit is a single zero or one)
unicode -(unicode is an international character encoding standard 
that provides a unique number for every character across languages and scripts).

>Signed value - values that can be negitive.

>Byte -  can hold Value from -128 to 127 (8-bit signed value).

>Char - can hold a single human readable character (16-bit unsigned unicode character).

>Short - can hold Value from -32768 to 32767 (16-bit signed value).

>Int - can hold value from -32768 to 32767 (16-bit signed value).

>Long - can gold value from -2^63 to (2^63)-1 (64-bit signed value).

>Booleans - can assign either true or false.

>Float - can store real numbers (32 - bite single-precision float).

>Double - can store real numbers (64 - bit single-precision float).

>Val - To inisiate none mutable varable.

>Var - To inisiate mutable varable.

## How to define
---

```scala
val msg = "Hello, World!"
```
This is defineing a varible, a none mutable variable 
called msg which contains the string "Hello, World!".

```scala
var msg2 = "Hello, World"
```
This is defineing a mutable variable that can be reassign by useing the below command.

```
msg2 = "Hello again World."
```

This is how you reassign ^.

## Define Some functions
---

This is a simple function named max that takes in two intigers and return the biggest intiger.

```scala
def max(x:Int, y:Int): Int = {
    if(x>y)
        x
    else
        y
}
```
* starts with **def** key World
* next **function name**
* inside the **( )** is the input variables
* next is **:** to indicate that the end of the variables.
* then is the **output type**
* inside the **{ }** is the function body

>Repl - Read execute print loop

>Quit - Typed to quit the SBT to quit the SBT

## Write Some Scala Scripts
---
### Print function
This is a simple print function that prints the inserted data to the screen
```scala
println("Hello, World, from a script!")
```
Then you run the program useing the blow command
>$scala hello.scala

Then you will get the output:
> \>>>Hello, Wrold, from a script!

---
### Print arguments
then you can write a the code like this to read input from the user through arguments

```scala
println("Hello, " + args(0) + "!")
```

Then run

>$scala hello.scala planet

In this command **planet** is in replacenment of **args(0)** since it is at the arg position 0
then you will get the output

> \>>>Hello, planet!

## Loop with while, decide with if
---
### While loop
```scala
var i = 0
while(i < args.length){
    println(args(i))
    i += 1
}
```

in this function there is a while loop checking
if the args.length is larger than zero.
if the length is larger than zero then it will continew print out the rest of the words

>$scala printargs.scala scala is fun!

next you will get the out put

> \>>>scala
> \>>>is
> \>>>fun!



|index(0) | index(1) | index(2)|
| ------- |----------| --------|
|scala    | is       | fun!    |
|i=0      | i=1      | i=2     |

args.length = 2

so it goes throw 'scala if fun!' one word by one printing all of them

## Iterate with foreach and for
---

### Foreach loop

```scala
args.foreach(arg => println(arg))
```

in this code the function takes in the args and println them one by one
you run this

>$scala pa.scala Concise is nice

the output will look like

> \>>>Concise
> \>>>is
> \>>>nice

### Another way to write foreach loop
```scala
args.foreach(println)
```

in this code it works the same as the code above.
it loops the args like 

>$scala pa.scala Concise is fun!

next the output is

> \>>>concise is fun!