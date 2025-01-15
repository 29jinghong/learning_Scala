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


trait Queue[T] {
  //define trait Queue containing T
  def head: T
  //define head as T type
  def tail: Queue[T]
  //define tail as a Queue and store type as T
  def append(x: T): Queue[T]
  //define append as Queue containing T and input x: T
}

object Queue {
  //define object Queue
  def apply[T](xs: T*): Queue[T] = {
    //define apply and "*" here means it can take 0 or more inputs
    new QueueImpl[T](xs.toList, Nil)
    //creating a new QueueImpl containing T and input xs.toList, and Nil
  }

  private class QueueImpl[T](
                            //define QueueImpl as a private class and containing T
                              private val leading: List[T],
                            //input private val leading as List containing T
                              private val trailing: List[T]
                            //input private trailing as List containing T
                            ) extends Queue[T] {
                            //extends off of Queue containing T
    def normalize =
    //define normalize
      if (leading.isEmpty) {
        //if the leading is empty this will run
        new QueueImpl(trailing.reverse, Nil)
        //this is done to create a list
      } else {
        //if the leading is not empty this will run
        this
        //here "this" means that noting is changed and its returning the input as it is
      }

    def head: T = {
      normalize.leading.head
      //setting the head to whats in the lead
    }

    def tail: QueueImpl[T] = {
      val q = normalize
      //setting q as normalize
      new QueueImpl(q.leading.tail, q.trailing)
      //creating a new QueueImpl input q.leading.tail as the first and q.trailing as the second argument
    }

    def append(x: T) = {
      new QueueImpl(leading, x :: trailing)
      //appending x in front of trailing and behind leading
    }
  }
}