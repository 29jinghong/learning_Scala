package org.programingscala.chapter24

import scala.annotation.tailrec

object Chapter24 {
  object Email {
    def unapply(str: String): Option[(String, String)] = {
      val parts = str.split("@")
      if (parts.length == 2) Some((parts(0), parts(1))) else None
    }
  }

  def main(args: Array[String]): Unit = {
    val email = "john@doe.com"

    email match {
      case Email(user, domain) =>
        println(s"User: $user, Domain: $domain")
      case _ =>
        println("Not a valid email")
    }

    object Email {
      def apply(user: String, domain: String): String =
        s"$user@$domain"

      def unapply(email: String): Option[(String, String)] = {
        val parts = email.split("@")
        if (parts.length == 2) Some((parts(0), parts(1))) else None
      }
    }

    val e = Email("alice", "scala.com")
    println(e)

    object Names {
      def unapplySeq(str: String): Option[Seq[String]] =
        Some(str.split(" "))
    }

    "Mary Jane Watson" match {
      case Names(first, middle, last) =>
        println(s"First: $first, Middle: $middle, Last: $last")
    }

    // pattermatching useing both apply and unapply
    //if you use case class apply and unapply is auto given
    class Person(val name: String, val age: Int)
    object Person {

      def apply(str: String, i: Int): Person = new Person(str, i)

      def unapply(full: Person): Some[(String, Int)] =
        Some((full.name, full.age))
    }

    val p1 = Person("jinghong", 22)
    p1 match {
      case Person(name, age) => println(s"$name, $age")
    }

    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factorialAcc(n * acc, n - 1)
    }

  }
}
