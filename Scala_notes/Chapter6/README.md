## 6.1 A specification for class Rational
rational number is a number that can be expressed as a ratio n/d

and adding two rational number is let them have the same denomnator and then adding the top

dividing two rational number is fliping one of them then times them

for example:

1/2 / 3/5 = 1/2 * 5/3 = 5/6

## 6.2 Constructing a Rational

construction a rational is simple you can just create a class named rational and ask for two numbers

```scala
class Rational(n: Int, d: Int)

then you can add a debug method by printing out the input to check if the class is created.

class Rational(n: Int, d: Int) {
    println("Created "+n+"/"+d)
}
```

if you run this you will get:

```
scala> new Rational(1, 2)
  Created 1/2
  res0: Rational = Rational@a0b0f5
```

## 6.3 Reimplementing the toString method

the output of the res0 will be Rational@a0b0f5:
Rational - is the class name.
@ - to show that after this will be hex numbers.
a0b0f5 - hex number for 1/2.

if you want the program to print human readable numbers you would need to override it.

override - override modifier in front of a method definition signals that a previous method definition is overridden

which looks like this:


class Rational(n: Int, d: Int) {
    override def toString = n+"/"+d
}

## 6.4 Checking preconditions

since in the priviouse code there is not a line that indicates the denomnator cant be zero you could actully do this:

```scala
scala> new Rational(5, 0)
res6: Rational = 5/0

which is not a valid number so you could add a precondition to the code to insure that is valid:

class Rational(n: Int, d: Int) {
    require(d != 0)
    override def toString = n+"/"+d
}
```

The require method takes one boolean parameter.
If the passed value is true, require will return normally.
Otherwise, require will prevent the object from being constructed by throwing an IllegalArgumentException.

## 6.5 Adding fields
adding a rational you would need to create a new rational since the numbers are not mutable
so you would need to define a add function:

```scala
def add(that: Rational): Rational =
      new Rational(n * that.d + that.n * d, d * that.d)
```

sadly thid dont work since you cant acces that.n or that.d

## 6.6 Self references

As in Java, the keyword this refers to the object instance
on which the currently executing method was invoked, or if used in a constructor,
the ob- ject instance being constructed. As an example, consider adding a method,
lessThan, which tests whether the given rational is smaller than a parameter:

```scala
def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
```
## 6.7 Auxiliary constructors

Auxiliary constructors in Scala start with def this(...).
The body of Rational’s auxiliary constructor merely invokes the primary constructor
passing along its lone argument, n, as the numerator and 1 as the denominator.
If you type the following into the interpreter:

def this(n: Int) = this(n, 1)

## 6.8 Private fields and methods

To normalize in this way, you need to divide the numerator and denominator by their greatest common divisor.
For example, the greatest common divisor of 66 and 42 is 6.
(In other words, 6 is the largest integer that divides evenly into both 66 and 42.)
Dividing both the numerator and denominator of
66/42 by 6 yields its reduced form.
Here’s how you could accomplish that in 11/7
Scala:

```scala
private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g
private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
```

## 6.9 Defining operators

The current implementation of Rational addition is OK as it stands,
but it could be made more convenient to use. You might ask yourself why you can write:
x + y
The first step is to replace add by the usual mathematical symbol.
This is straightforward, as + is a legal identifier in Scala.
You can simply define a method with + as its name.
While you’re at it, you may as well implement a method named * that performs multiplication:

```scala
def +(that: Rational): Rational =
    new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )

def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
```

## 6.10 Identifiers in Scala
An alphanumeric identifier starts with a letter or underscore,
which can be followed by further letters, digits, or underscores.
The ‘$’ character also counts as a letter, however it is reserved
for identifiers generated by the Scala compiler. Identifiers in user
programs should not contain ‘$’ characters, even though it will compile;
if they do this might lead to name clashes with iden- tifiers generated by the Scala compiler.


## 6.11 Method overloading

To make Rational even more convenient, you can add new methods to the class
that perform mixed addition and multiplication on rationals and integers.
While you’re at it, you may as well add methods for subtraction and division too:

```scala
def +(that: Rational): Rational =
    new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )

def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

def -(that: Rational): Rational =
    new Rational(
        numer * that.denom - that.numer * denom,
        denom * that.denom
    )

def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

def *(i: Int): Rational =
    new Rational(numer * i, denom)

def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

def /(i: Int): Rational =
    new Rational(numer, denom * i)
```

## 6.12 Implicit conversions

Now that you can write r * 2, you might also want to swap the operands, as
in 2 * r. Unfortunately this does not work yet:

You can create an implicit conversion that automatically converts integers to rationals when needed.
Try to add this line in the interpreter:

> scala> implicit def intToRational(x: Int) = new Rational(x)


This defines a conversion method from Int to Rational.
The implicit modifier in front of the method tells the compiler to apply it automatically
in a number of situations. With the conversion defined.
Note that for an implicit conversion to work, it needs to be in scope.
If you place the implicit method definition inside class Rational, it won’t be in scope in the interpreter.
For now, you’ll need to define it directly in the interpreter.

## 6.13 A word of caution
As this chapter has demonstrated, creating methods with operator names and defining implicit conversions
can help you design libraries for which client code is concise and easy to understand.
If used unartfully, both operator methods and implicit conversions can give rise to client code that is hard to read and understand.

Because implicit conversions are applied implicitly by the compiler, not explicitly written
 down in the source code, it can be non-obvious to client programmers what implicit conversions are being applied.

