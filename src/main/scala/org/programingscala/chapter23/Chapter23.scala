package org.programingscala.chapter23

object Chapter23 {
  def main(args: Array[String]): Unit = {
    //23.1
    case class Person(name: String,
                      isMale: Boolean,
                      children: Person*)

    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)

    val persons = List(lara, bob, julie)

    //
    val motherChildPair =
      for {
        p <- persons //if ! p.isMale
        c <- p.children
      } yield (p.name, c.name)

    //you can also write this with filter and flatmap
    val motherChildPair2 =
      persons
        .filter { p => ! p.isMale }
        .flatMap {
          p => p.children.map {
            c => (p.name, c.name)
          }
        }

    val motherChildPair3 =
      persons.flatMap { p =>
          p.children.map { c =>
            (p.name, c.name)
          }
        }

    println(motherChildPair2)
    println()
    println(motherChildPair)


    motherChildPair foreach println

    val bobName =
      for {
        p <- persons if (p.name startsWith "Bo") // a generator that iterates over all elements with a filter
      } yield {
        p.name
      }


    val bobName2 =
      persons
        .filter { p => p.name startsWith "Bo" }
        .map { p => p.name }

    println(bob)

    val num =
      for {
        x <- List(1, 2)
        y <- List("one", "two")
        z <- List("a", "b")
      } yield {
        (x,y,z)
      }

    println(num)

    val i1: Option[Int] = Some(1)
    val i2: Option[Int] = Some(2)
    val i3: Option[Int] = None

    val sum =
      for{
        x <- i1
        y <- i3
        z <- i2
      } yield x + y + z

    println(sum)




  }
}