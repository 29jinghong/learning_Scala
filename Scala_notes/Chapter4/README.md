# Chapter 4

## Classes and Objects

### Classes, fields, and methods

class are blue prints of object a class can create infint amount of objects.
once you created a class you can then use the ***new*** key word to crate a object of that class.

```scala 
class ChecksumAccumulator
{

}

new ChecksumAccumulator
```

you can create a ChecksumAccumulator object useing the key word ***new*** which is also called a instance of the class ChecksumAccumulator.

inside the class definition you can put fields and methods which is also called ***members***

members - whats inside the class definition
fields - val, var
methods - startes with def

if you defined a ChecksumAccumulator class and gave it a var field named sum:

```scala
class ChecksumAccumulator
{
    var sum = 0
}

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator
```

the acc's and the csa's sum all point to 0 since the class definition defined it.

but you can change the sum of the acc or the csa by doing the following:

```scala
acc.sum = 3
```

then only the acc's sum will be changed to 3 the csa will remain the same.

#### privite varables
---
you can make the varables inside the class private by adding the keyword ***private*** this makes the varable not accesable from the outside.

```scala
class ChecksumAccumulator
{
    private var sum = 0
}
```

the only way to change a private var is to add methods inside class

```scala
class ChecksumAccumulator
{
    private var sum = 0

    def add(b: Byte): Unit = {
      sum += b
    }

    def checksum(): Int = {
        return ~(sum & 0xFF) + 1
    }
}
```

while formating your code there is serten conditions you have to follow

1. The line in question ends in a word that would not be legal as the end of a statement, such as a period or an infix operator.
2. The next line begins with a word that cannot start a statement.
3. The line ends while inside parentheses (...) or brackets [...], be- cause these cannot contain multiple statements anyway.

#### varable scope
---
varable scope is defined by every thing inside the curly brakes for example:

```scala
def printMultiTable() {
    var i = 1
    // only i in scope here
    while (i <= 10) {
        var j = 1
        // both i and j in scope here
        while (j <= 10) {
            val prod = (i * j).toString
            // i, j, and prod in scope here
            var k = prod.length
            // i, j, prod, and k in scope here
            while (k < 4) {
                print(" ")
                k += 1
            }
            print(prod)
            j += 1 }
        // i and j still in scope; prod and k out of scope
        println()
        i += 1 }
    // i still in scope; j, prod, and k out of scope
  }
printMultiTable()
```

A class is a blueprint for objects. Once you define a class, 
you can create objects from the class blueprint with the keyword new.
For example, given the class definition

object is also a instance of a class

it takes in a string and caculate it into a int based on the 

0xff is a number represented in the hexadecimal numeral system (base 16).
It's composed of two F numbers in hex. As we know,
F in hex is equivalent to 1111 in the binary numeral system. So, 0xff in binary is 11111111.

the method looks like a procedure
& procedure style

however, in that Scala allows you to define variables of the same name in nested scopes.(90)
^what happend in pg 92? (how would you print out the first one on sbt)

```scala
for (i <- 1 to 10) {
      for (j <- 1 to 10) {
        val num = j
        print(num)
        }
    }
```

this would work because every time the loop goes by is just making a new val named num

a singleten object is a object that is defined once 

companion object are objects that has the same name with a class

standalone object are objects that dont have a class referance
