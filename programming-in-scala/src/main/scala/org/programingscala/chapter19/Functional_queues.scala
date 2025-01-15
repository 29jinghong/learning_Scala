package org.programingscala.chapter19

import scala.collection.mutable

class Functional_queues {
  val q = mutable.Queue(1, 2, 3)
  val q1 = q append 4
}

//Big O notation
class Queue1[T](elems: List[T]) {
  def head = elems.head
  //head would have a complexity of O(1)
  def tail = elems.tail
  def append(x: T) = new Queue1(elems ::: List(x))
  //append would have a complexity of O(n)
  //n here is how many input are made^
  //because how append would work here would be taking elems apart and then adding List(x) to the last
  //which would look like this
  //1,2,3,4 + 5
  //2,3,4 + 5
  //3,4 +5
  //4 + 5
  //3 + 4,5
  //2 + 3,4,5
  //1 + 2,3,4,5
}

class Queue2[T](smele: List[T]) {
  def head = smele.last
  //head would have a complexity of O(n)
  //because you are getting the last thing in the list so you would need to
  //pop every thing from the top first and then you are able to access the last
  def tail = smele.init
  def append(x: T) = new Queue2(x :: smele)
  //append would have a complexity of O(1)
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
