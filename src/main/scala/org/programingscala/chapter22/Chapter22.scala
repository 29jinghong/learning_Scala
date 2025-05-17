package org.programingscala.chapter22

// Define an abstract base class
sealed trait MyList[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: MyList[A]
  def ::[B >: A](elem: B): MyList[B] = Cons(elem, this)

  def map[B](f: A => B): MyList[B]
  def foreach(f: A => Unit): Unit
}

// Empty list object
case object MyNil extends MyList[Nothing] {
  def isEmpty = true
  def head = throw new NoSuchElementException("head of empty list")
  def tail = throw new NoSuchElementException("tail of empty list")

  def map[B](f: Nothing => B): MyList[B] = MyNil
  def foreach(f: Nothing => Unit): Unit = ()
}

// Non-empty list case class
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A] {
  def isEmpty = false

  def map[B](f: A => B): MyList[B] = Cons(f(head), tail.map(f))
  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }
}

// Test the implementation
object MyListDemo extends App {
  val list = 1 :: 2 :: 3 :: MyNil

  println("Original list:")
  list.foreach(println)

  println("\nMapped list (*2):")
  val doubled = list.map(_ * 2)
  doubled.foreach(println)

  println(s"\nHead: ${list.head}")
  println(s"Tail: ${list.tail}")
  println(s"Is empty? ${list.isEmpty}")
}