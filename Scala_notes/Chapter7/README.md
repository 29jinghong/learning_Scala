# Chapter 7

Built-in Control Structures


There are not many control structures built into Scala.
The only control structures are if, while, for, try, match, and function calls.

## 7.1 If expressions

imperative style:

```scala
var filename = "default.txt"

if (!args.isEmpty)
    filename = args(0)
```

here is the code writen in imperative style.

functional style:

```scala
val filename = if (!args.isEmpty) args(0)
    else "default.txt"
```

and here is the code written in a more function style.

functional style overe here is better than the imperative style because of two things
first it is a little shorter
next the most important factor is that the value in function style is val which is unmuteable

1) It tells you that the variable will never change, saving you from scanning all code in the variable’s
   scope to see if it ever changes.

2) using a val instead of a var is that it better supports equational reasoning.
   The introduced variable is equal to the expression that computes it, assuming that expression has no side effects.

For both of these reasons, you should look for opportunities to use vals wherever possible.
makes your code easer to read and refactor

Any type can be implicitly converted to Unit if need be
When a value’s type is converted to Unit, all information is lost about that value.

scala's while loop works like the others too which keeps on looping while the condition is true.

```scala
def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
        val temp = a 
        a= b % a 
        b = temp
    }
    b
}
```

Scala also has a do-while loop.
This is a variant of the while loop that simply tests the condition after the loop body instead of before

```scala
var line = ""
    do {
        line = readLine()
        println("Read: " + line)
    } while (line != null)
```

comparing values of type Unit and Null using != will always yield true.
assignment always results in the unit value
(line = readLine()) will be unit

```scala
var line = ""

while ((line = readLine()) != null)
    println("Read: " + line)
```

this is a functional style way to write gcdLoop

```scala
def gcd(x: Long, y: Long): Long = if 
    (y == 0) x else gcd(y, x % y)
```

because while loops need to constantly change the var to return the correct value it is impresive style

## 7.3 For expressions

Iteration through collections

```scala
val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere)
    println(file)
```

You can create Ranges using syntax like “1 to 5,” and you can iterate through them with a for.

```scala
scala> for (i <- 1 to 4)
    |  println("Iteration " + i)
```

## 7.4 Try expressions

```scala
throw new NullPointerException
```

this is the key word for throwing expressions 

```scala
val half =
    if (n % 2 == 0)
    n/2 else
    throw new Exception("n must be even")
```

in the above expression if have is even number then half would equal to n/2
else it will throw an exception which nothing will be done.

```scala
pattern matching:
try {
    doSomething()
    } catch {
        case ex: IOException => println("Oops!")
        case ex: NullPointerException => println("Oops!!")
}
```

## 7.5 Match expressions

```scala
val firstArg = if (args.length > 0) args(0) else ""
firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
}
```

overe here you can see the matching example, if the args contain any thing in the following words
the prgram will print out a companion to that food. 
if the food dont exist thats where the "_" comes in place it will match any thing works like a else for if.

```scala
val firstArg = if (!args.isEmpty) args(0) else ""
  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
  println(friend)
```

you can also do this to return the value so it can be printed later on.

## 7.6 Living without break and continue

for scala there is no breake or continue, you can replace them with a if for contnue and break by a boolean variable.

```scala
var i = 0
  var foundIt = false
  while (i < args.length && !foundIt) {
    if (!args(i).startsWith("-")) {
      if (args(i).endsWith(".scala"))
        foundIt = true
}
i=i+1 }
```

in this you can see you simply replace the breake with foundIt = true and since in the while loop statnment you have a && !foundIt this will end the loop.

```scala
def searchFrom(i: Int): Int =
    if (i >= args.length)  // don’t go past the end
        -1
    else if (args(i).startsWith("-"))  // skip options
        searchFrom(i + 1)
    else if (args(i).endsWith(".scala"))  // found it!
        i
    else
        searchFrom(i + 1)   // keep looking
    val i = searchFrom(0)
```
in this case you can define a function for that have a humanble read laugange

 