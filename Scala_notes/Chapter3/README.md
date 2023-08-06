# Chapter 3 (pg62)

## Step7: Parameterize Arrays with types

in scala you can parameterize arrays with type 
which means you can set the data type you store in arrays

```scala
val greetStrings = new Array[String](3)
```

weekly questions:

Parameterization means configuring an instance when you create it.(62 pg)
does scala have a "Any" type?
yes but its bad to use it since Scala is a strongly typed launguage and use Any will lose all the benefits for that
founded out in sbt
parameterization:

val greetStrings = new Array[String](3)



operator overloading(64 pg)

basicaly means polymorphic function
for example:
1 + 2

"he" + " she"

1.1 + 2.3

you can pass in diferent type with the same function 



in Java primitive and their corresponding wrapper types(65 pg)
basically in java not every thing is object so it hase primitive types for example: int, long, boolean, short.
then for each of the primitive types there is a corresponding wrapper type, "1" can have a wrapper value of "new Integer(1)"
and "new Integer(1)" is an object


what is the deference between Array and List?
