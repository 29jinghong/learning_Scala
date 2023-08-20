# Chapter 5

## 5.1 Some basic types

|Value Type     |         Range                                                           |
|---------------|-------------------------------------------------------------------------|
|Byte           |     8-bit signed two’s complement integer (-27 to 27 - 1, inclusive)    |
|Short          |     16-bit signed two’s complement integer (-215 to 215 - 1, inclusive) |
|Int            |     32-bit signed two’s complement integer (-231 to 231 - 1, inclusive) |
|Long           |     64-bit signed two’s complement integer (-263 to 263 - 1, inclusive) |
|Char           |     16-bit unsigned Unicode character (0 to 216 - 1, inclusive)         |
|String         |     a sequence of Chars                                                 |
|Float          |     32-bit IEEE 754 single-precision float                              |
|Double         |     64-bit IEEE 754 double-precision float                              |
|Boolean        |     true or false                                                       |

## 5.2 Literals

A literal is a way to write a constant value directly in code.


Integer literals:


If the number begins with a 0x or 0X, it is hexadecimal
If the number begins with a zero, it is octal
If the number begins with a non-zero digit, it is decimal
If an integer literal ends in an L or l, it is a Long, otherwise it is an Int.


Floating point literals:


any thing that hase a decemal in it is a floating point literals or optionally followed by an E or e and an exponent.
If a floating-point literal ends in a F or f, it is a Float, otherwise it is a Double.


Character literals:


Character literals can be any Unicode character between single quotes(')
In addition to providing an explicit character between the single quotes, you can provide an octal or hex number for the character code point preceded by a backslash.


A character literal can also given as a general unicode character consisting of four hex digits and preceded by a \u, as in:

```
B\u0041\u005a
is BAZ
```

String literals:


The usual notation for a string literal is to surround a number of characters by double quotes (")

|Literal    |     Meaning                   |
|-----------|-------------------------------|
|\n         |     line feed (\u000A)        |
|\b         |     backspace (\u0008)        |
|\t         |     tab (\u0009)              |
|\f         |     form feed (\u000C)        |
|\r         |     carriage return (\u000D)  |
|\"         |     double quote (\u0022)     |
|\'         |     single quote (\u0027)     |
|\\         |     backslash (\u005C)        |

You start and end a raw string with three quotation marks in a row ("""). 
in a raw string you dont need to type \\ for a single back slash.
The interior of a raw string may contain any characters whatso ever,
including newlines, quotation marks, and special characters, except of course three quotes in a row.

The issue is that the leading spaces before the second line are included in the string!
To help with this common situation, the String class includes a method call stripMargin.
To use this method, put a pipe character (|) at the front of each line, and then call stripMargin on the whole string:

```scala
println("""|Welcome to Ultamix 3000.
            |Type "HELP" for help.""".stripMargin)
```

this will come out in one line

> Welcome to Ultamix 3000.
>
>  Type "HELP" for help.

Boolean literals:

The Boolean type has two literals, true and false

## 5.3 Operators are methods

all methods in Scala can be used in operator notation

In Scala, an operator is a method—any method—invoked without the dot using one of three operator notations:

prefix, postfix, or infix.

In **prefix** notation, you put the method name before the object on which you are invoking the method, for example, the “-” in “-7”.

In **postfix** notation, you put the method after the object, for example, the toLong in “7 toLong”.

In **infix** notation, you put the method between the object and the parameter or parameters you wish to pass to the method, for example, the + in “7 + 2”

```scala
scala> -2.0                  // Scala invokes (2.0).unary_-
res1: Double = -2.0

scala> (2.0).unary_-
res2: Double = -2.0
```

The only identifiers that can be used as prefix operators are +, -, !, and ~

convention is if the method takes no side affect have the () else leave them off

## 5.4 Arithmetic operations

```scala
scala> 1.2 + 2.3
res6: Double = 3.5

scala> 3 - 1
res7: Int = 2

scala> 'b' - 'a'
res8: Int = 1

scala> 2L * 3L
res9: Long = 6

scala> 11 / 4
res10: Int = 2

scala> 11 % 4 
res11: Int = 3

scala> 11.0f / 4.0f
res12: Float = 2.75

scala> 11.0 % 4.0 
res13: Double = 3.0
```

## 5.5 Relational and logical operations

```scala
scala> 1 > 2
res16: Boolean = false

scala> 1 < 2
res17: Boolean = true

scala> 1.0 <= 1.0
res18: Boolean = true

scala> 3.5f >= 3.6f
res19: Boolean = false

scala> 'a' >= 'A'
res20: Boolean = true

scala> val thisIsBoring = !true
thisIsBoring: Boolean = false
```
this is useing unary_! method^

```scala
scala> !thisIsBoring
res21: Boolean = true

scala> val toBe = true
toBe: Boolean = true

scala> val question = toBe || !toBe
question: Boolean = true

scala> val paradox = toBe && !toBe
paradox: Boolean = false
```

the logical-and and logical-or is a short-circuited which means if the left side of the 
logical-and is false then it wouldent go the the left side it would just stop it there

```scala
scala> def salt() = { println("salt"); false }
salt: ()Boolean

scala> def pepper() = { println("pepper"); true }
pepper: ()Boolean

scala> salt() && pepper()
salt
res22: Boolean = false

scala> pepper() && salt()
pepper
salt
res23: Boolean = false
```

## 5.6 Object equality

If you want to compare two objects to see if they are equal,
you should usually use either ==, or its inverse !=.

These operations actually apply to all objects, not just basic types.
For example, you can use it to compare lists:

```scala
scala> List(1, 2, 3) == List(1, 2, 3)
res27: Boolean = true

scala> List(1, 2, 3) == List(4, 5, 6)
res28: Boolean = false
```

## 5.7 Bitwise operations

The bitwise methods are: bitwise-and (&), bitwise-or (|), and (or bitwise-xor) (ˆ).

The unary bitwise complement op- erator, ~ (the method unary_~), inverts each bit in its operand:

```scala
scala> 1 & 2
res34: Int = 0
```
1 & 2, bitwise-ands each bit in 1 (0001) and 2 (0010), which yields 0 (0000).

```scla
scala> 1 | 2
res35: Int = 3
```
The second expression, 1 | 2, bitwise-ors each bit in the same operands, yielding 3 (0011).

```scala
scala> 1 ˆ 3
res36: Int = 2
```
1 ˆ 3, bitwise-xors each bit in 1 (0001) and 3 (0011), yielding 2 (0010)

```scala
scala> ~1
res37: Int = -2
```
~1, inverts each bit in 1 (0001), yielding -2, which in binary looks like 111111111111111111111111111110.


Scala integer types also offer three shift methods:

shift left (<<)

shift right (>>)

and unsigned shift right (>>>).

```scala
scala> -1 >> 31
res38: Int = -1
```
-1 >> 31, -1 is shifted to the right 31 bit positions.

Since an Int consists of 32 bits, this operation effectively moves the leftmost bit over until

it becomes the rightmost bit.10 Since the >> method fills with ones as it shifts right, because the leftmost bit of -1 is 1, the result is identical to the original left operand, 32 one bits, or -1.

```scala
scala> -1 >>> 31
res39: Int = 1
```

In the second example, -1 >>> 31, the leftmost bit is again shifted right until it is in the rightmost position, but this time filling with zeroes along the way.
Thus the result this time is binary 00000000000000000000000000000001, or 1.

```scala
scala> 1 << 2
res40: Int = 4
```

1 << 2, -the left operand, 1, is shifted left two positions (filling in with zeroes), resulting in binary 00000000000000000000000000000100, or 4.


Scala compiler daemon(99)

Since the Scala compiler can be a bit slow to startup
Scala has a compiler daemon you can run. This daemon keeps running
even when not compiling Scala code. 
You can then instruct the daemon to compile Scala code for you at will.
This saves you the Scala compiler startup overhead when compiling

scala compiler daemon is a way to save time?

so if you start up sbt it will create a deamon that compiles changes in realtime


A literal is a way to write a constant value directly in code.
so basicaly just:
```scala
val a: Int = 3
```

so you dont need to crate a class, you can just create a value since is build into the lauange

You can even compare against null, or against things that might be null. 

No exception will be thrown:

first check the left side for null, and if it is not null, call the equals method.

Since equals is a method, the precise comparison you get depends on the type of the left-hand argument.

in scala never use null since is a java thing

(doing == for two null will cause a null point exception):
java.lang.NullPointerException

except .== which they did some thing with in scala


## 5.8 Operator precedence and associativity

operator precedence is how math simbles work basicaly left to right and * % befor + -.

Operator precedence

From top to down:

(all other special characters) 

*/%

+-

:

=! 

<> 

&

ˆ

|

(all letters)


> associativity - is how the in the code : is alawst on the side of the list.
```scala
list :+ "hi"
```


a ::: b ::: c

is treated as

a ::: (b ::: c).

But

a * b * c

is treated as

(a * b) * c.
