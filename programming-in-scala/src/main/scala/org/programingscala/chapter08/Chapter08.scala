package org.programingscala.chapter08
import scala.io.Source


object Chapter08
{
/*
8.1 Methods

methods - a member of some object
*/
def processFile(filename: String, width: Int): Unit = {
      val source = Source.fromFile(filename)
      for (line <- source.getLines)
        processLine(filename, width, line)
    }

def processLine(filename:String, width:Int, line:String): Unit = {
      if (line.length > width)
        println(filename+": "+line.trim)
    }
/*
Method Definition: def drop(n: Int): List[A]

Where, n is the number of elements to be dropped from the stated sequence.

Return Type: It returns all the elements of the list except the first n ones.


8.2 Local functions

local functions are functions inside a nother functions
*/
def processFileV2(filename: String, width: Int): Unit ={
    def processLineV2(line:String): Unit ={
        if (line.length > width) print(filename+": "+line)
    }
        val source: Source = Source.fromFile(filename)
        for (line <- source.getLines) {
            processLineV2(line)
        }
    }
/*
local functions can access the parameters of their enclosing function.
so you can simplyfy the code like this:
*/

    def processFileV3(filename: String, width: Int): Unit = {
        def processLineV3(line: String): Unit = {
            if (line.length > width) print(filename+": "+line)
        }
        val source = Source.fromFile(filename)
        for (line <- source.getLines) {
            processLineV3(line)
        }
    }

/*


8.3 First-class functions

first-class function - you can write down as unnamed function and pass it around as a value
*/
    def increasingNum(): Unit = {
        var increase = (x: Int) => x + 1

/*
this is a first class function you can later pass it into a nother function.
*/

        val num = increase(10) 

/*
num will be 11


there is also a fulter method in scala:
*/

        val someNumbers = List(-11, -10, -5, 0, 5, 10)

        var newsomeNumbers = someNumbers.filter((x: Int) => x > 0)
    }
/*
this is a filter that passes int x and return whats biger than zero
"x > 0"


8.4 Short forms of function literals

scala can simplyfy function literals in a shorter form which pervents clutered code

for example you can write the prvous code like this:

scala> someNumbers.filter((x: Int) => x > 0)
```

```
someNumbers.filter((x) => x > 0)
```

and you can ferter simplyfy by removeing the "()" around the x

```
someNumbers.filter(x => x > 0)
```


8.5 Placeholder syntax

then you can also simplyfy it by useing a Placeholder syntax " x => x" into "_"

```
someNumbers.filter(_ > 0)
```

some times when you use "_" it might not have enyough enformation for the function to work

```
val f = _ + _
```

so you need to specify the types using a colon

```
val f = (_: Int) + (_: Int)
```


8.6 Partially applied functions

you can also replace alot of things with "_", for example you can replace println with "_"

```
someNumbers.foreach(x => println(x))
```

into the following

```
someNumbers.foreach(println _)
```

partially applied function is an expression in which you don’t supply all of the
arguments needed by the function. Instead, you supply some, or none,
of the needed arguments.

```
val a = sum _

a(1, 2, 3)
```

in this above example it shows how partially applied function is used,
first you set a equals to sum _, which then can use a(1, 2, 3) which is a apply function
a.apply(1, 2, 3)
which will basically become

```
sum(1, 2, 3)
```

which in this case will return 6

in a partially applied function you can also apply some but not all of the required arguments

```
val b = sum(1, _: Int, 3)
b(2)
```

and since all the other arguments is filled in you only need to input one value to get a answer
and the above code will return 6

If you are writing a partially applied function expression in which you

leave off all parameters, such as println _ or sum _,
you can express it more concisely by leaving off the underscore if a function
is required at that point in the code.

so insted of this:
```
someNumbers.foreach(println _)
```
You could just write:
```
someNumbers.foreach(println)
```

This last form is allowed only in places where a function is required,
such as the invocation of foreach in this example.
The compiler knows a function is required in this case,
because foreach requires that a function be passed as an argument.
In situations where a function is not required,
attempting to use this form will cause a compilation error. Here’s an example:

```
val c = sum
```

because the sum here needs a set of number insted of a function
so it will not work and give you an error

*/

}
