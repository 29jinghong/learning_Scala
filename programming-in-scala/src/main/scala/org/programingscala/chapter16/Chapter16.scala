package org.programingscala.chapter16

class Chapter16 {
    def main(args: Array[String]): Unit = {
        val nums: List[Int] = List(1, 2, 3, 4)
        val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
        val empty: List[Nothing] = List()
        //all things in list have to be the same type

        val xs: List[String] = List()
        //you can do this because List[String] is under List()

        val fruit: List[String] = "apples" :: ("oranges" :: ("pears" :: Nil))
        //List("apples", "oranges", "pears")
        print(fruit)
  }
}
