# Chapter 2 (pg48)

## First Steps in Scala

### Step1: Learn to use the Scala interpreter
---

> shell - a simple type an expression into the interpreter and it will 

evaluate the expression and print the resulting value.

you can activate scala shell useing scala 

you can then type in
```scala
1+1 
```

which will return 

> res0: Int = 3

this contains:

1. a genrated name or user defined name "res0"
2. a colon 
3. the type of the value
4. an equal sign
5. the value

the data type in scala is some what simular to java's just a little defrent
for example scala.Boolean corresponds to Java’s 
boolean.scala.Float corresponds to Java’s float

you then can use res0 later on since is stored into the shell system
for example you can type

```scala
res0 * 3
```

you will get the output as

> res1: Int = 9


Data types: 

>Bit - (a bit is a single zero or one)

> unicode -(unicode is an international character encoding standard 
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

## Step2: define some variables
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

```scala
msg2 = "Hello again World."
```

This is how you reassign ^.

## Step3: Define Some functions
---


scala have two kind of varables var and val
where var can be reassinged unlimited times and val can not be reassinged

for example :

```scala
val msg = "Hello, world!"
```

where the msg is assinged as a val which cant be reassinged 
you can later on use this value by

```scala
println(msg)
```

but since the msg is not assined useing var 
doing :

```scala
msg = "Goodbye cruel world!"
```

will cause the system to output:

```
<console>:5: error: reassignment to val
         msg = "Goodbye cruel world!"
             ˆ
```

if you want to reassing def the value useing var:

```scala
var msg1 = "hi"
```

then you can reassing by typeing:

```scala
msg1 = "hi again!"
```

This is a simple function named max that takes in two intigers and return the biggest intiger.

```scala
def max(x:Int, y:Int): Int = {
    if(x>y)
        x
    else
        y
}
```
1. starts with **def** key World
2. next **function name**
3. inside the **( )** is the input variables
4. next is **:** to indicate that the end of the variables.
5. then is the **output type**
6. inside the **{ }** is the function body

>Repl - Read execute print loop

>Quit - Typed to quit the SBT to quit the SBT


you can also write the max function like this:

```scala
def max2(x: Int, y: Int) = if (x > y) x else y
```

since you can leave off the {} it can be written in this one single line
then you can use the max function by typeing:

```scala
max(2, 3)
```

it will then output:

```scala
res0 = Int = 3
```

functions can return deferent results too for example 
Int means the function returns an int and 
when the function don't return any thing it returns a unit


## Step4: Write Some Scala Scripts
---

### Print function
you can wirte some simple scripts in scala too for example 

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

this line of code takes input derectly from the command line and print out the output.

the code args(0) means that is going to print the position 0 of the args.

so if you run:

> scala hello.scala planet

it will print 
Hello, planet!

concatenating string
you can concatenat strings useing the + oprator which looks like this:
"hello" + " world"

In this command **planet** is in replacenment of **args(0)** since it is at the arg position 0
then you will get the output

> \>>>Hello, planet!

## Step5: Loop with while, decide with if
---

imperative style(pg 59)

val ints = List(1, 2, 3)

  // Imperative
  var plus1: List[Int] = Nil
  for(i <- ints) {
    plus1 = plus1 :+ (i + 1)
  }

  // Functional
  val intsChanged: List[Int] = ints.map(i => i + 1)
  
  List(1, 2, 3) foreach println

a => b (this is a function)


> type inference - when you declare a variable most of the time you would not need to add a type annotation.


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


you can write a while loop the same as in java
> block - the code between the curly braces


|index(0) | index(1) | index(2)|
| ------- |----------| --------|
|scala    | is       | fun!    |
|i=0      | i=1      | i=2     |

args.length = 2

so it goes throw 'scala if fun!' one word by one printing all of them

## Step6: Iterate with foreach and for
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