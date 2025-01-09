package org.programingscala.chapter19

import scala.collection.mutable

class Functional_queues {
  val q = mutable.Queue(1, 2, 3)
  val q1 = q append 4
}

class Queue1[T](elems: List[T]) {
  def head = elems.head
  def tail = elems.tail
  def append(x: T) = new Queue1(elems ::: List(x))
}

class Queue2[T](smele: List[T]) {
  def head = smele.last
  def tail = smele.init
  def append(x: T) = new Queue2(x :: smele)
}

class Queue[T](
                private val leading: List[T],
                private val trailing: List[T])
{
  private def mirror =
    if (leading.isEmpty) new Queue(trailing.reverse, Nil)
    else this
  def head =
    mirror.leading.head
  def tail = {
    val q = mirror;
    new Queue(q.leading.tail, q.trailing)
  }
  def append(x: T) =
    new Queue(leading, x :: trailing)
}