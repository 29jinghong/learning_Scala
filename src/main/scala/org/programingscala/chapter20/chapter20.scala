package org.programingscala.chapter20

object chapter20 {
  // Defining a trait with an abstract type and abstract members
  trait Abstract {
    type T // Abstract type member

    def transform(x: T): T // Abstract method to transform a value of type T

    val initial: T // Abstract immutable value
    var current: T // Abstract mutable variable
  }

  // Concrete implementation of Abstract trait
  class Concrete extends Abstract {
    type T = String // Specifying the concrete type as String

    def transform(x: String) = x + x // Implements transform by concatenating the string

    val initial = "hi" // Defines initial value
    var current = initial // Sets current to initial value
  }

  //20.3 Abstract vals
  // Abstract class with an abstract val and method
  abstract class Fruit {
    val v: String // Abstract value (must be defined in subclasses)

    def m: String // Abstract method (must be implemented in subclasses)
  }

  // Subclass of Fruit overriding abstract members
  abstract class Apple extends Fruit {
    val v: String // Overrides abstract val
    val m: String // Overrides abstract method with a val (allowed)
  }

  // Invalid subclass attempting to override val with def
  abstract class BadApple extends Fruit {
    def v: String // ERROR: Cannot override a val with a def

    def m: String // Correctly overrides method
  }

  //20.4 Abstract vars
  trait AbstractTime {
    def hour: Int // Abstract getter for `hour`

    def hour_=(x: Int) // Abstract setter for `hour`

    def minute: Int // Abstract getter for `minute`

    def minute_=(x: Int) // Abstract setter for `minute`
  }

  //20.5 Initializing abstract vals
  trait RationalTrait {
    val numerArg: Int // Abstract numerator
    val denomArg: Int // Abstract denominator
    require(denomArg != 0) // Ensures denominator is not zero

    private val g = gcd(numerArg, denomArg) // Compute greatest common divisor
    val numer = numerArg / g // Simplify numerator
    val denom = denomArg / g // Simplify denominator

    private def gcd(a: Int, b: Int): Int = // Function to compute GCD
      if (b == 0) a else gcd(b, a % b)

    override def toString = numer + "/" + denom // Override toString for display
  }

  // Instantiating RationalTrait with concrete values
  object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
  } with RationalTrait

  // Class extending RationalTrait with constructor parameters
  class RationalClass(n: Int, d: Int) extends {
    val numerArg = n
    val denomArg = d
  } with RationalTrait {
    // Method for adding rational numbers
    def +(that: RationalClass) = new RationalClass(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  // Using lazy evaluation to initialize values only when needed
  trait LazyRationalTrait {
    val numerArg: Int
    val denomArg: Int
    lazy val numer = numerArg / g // Compute numerator lazily
    lazy val denom = denomArg / g // Compute denominator lazily

    override def toString = numer + "/" + denom

    private lazy val g = {
      require(denomArg != 0) // Ensure denominator is not zero
      gcd(numerArg, denomArg) // Compute GCD lazily
    }

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)
  }

  //20.6 Abstract types
  class Food // Base class for food items

  abstract class Animal {
    type SuitableFood <: Food // Abstract type bounded to be a subtype of Food

    def eat(food: SuitableFood) // Method requiring a SuitableFood instance
  }

  class Grass extends Food // Grass is a type of Food

  class Cow extends Animal {
    type SuitableFood = Grass // Defines SuitableFood as Grass for cows

    override def eat(food: Grass) {} // Implements eat method
  }

  class Fish extends Food // Fish is also a type of Food

  val bessy: Animal = new Cow // Creating an instance of Cow as an Animal

  //20.7 Path-dependent types
  class DogFood extends Food
  class Dog extends Animal {
    type SuitableFood = DogFood // Defines DogFood as the suitable food for Dogs
    override def eat(food: DogFood) {} // Implements eat method
  }

  class Outer {
    class Inner // Inner class
  }

  val o1 = new Outer // Instance of Outer
  val o2 = new Outer // Another instance of Outer

  //20.8 Enumerations
  object Color extends Enumeration {
    val Red, Green, Blue = Value // Define enumeration values
  }

  object Direction extends Enumeration {
    val North = Value("North") // Assigning specific string values
    val East = Value("East")
    val South = Value("South")
    val West = Value("West")
  }
}
