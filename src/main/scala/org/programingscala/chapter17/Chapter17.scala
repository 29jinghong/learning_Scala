package org.programingscala.chapter17
import scala.collection.mutable.ArrayBuffer

object Chapter17 {
  def main(args: Array[String]): Unit = {
    //Sequences

    //arrays
    val numbers = new Array[Int](5)
    numbers(3)
    //how to read the number in index location 3

    numbers(3) = 42
    //how to set index location 3 to 42

    numbers.update(4, 420)
    //its works the same as above seting index position 4 to 420

    for (x <- numbers)
      println(x+" ")
    //looping throw numbers and printing out each number

    val words = "The quick brown fox".split(" ")
    //making a array of word

    for (word <- words)
      println(word)
    //looping throw words to print out each word in it

    val buf = new ArrayBuffer[Int]()
    //making a array buffer
    buf += 12
    buf += 15
    //adding to array buffer
    for (num <- buf) {
      println(num)
    }
    //looping throw buf to print out each number

    //Tuples
    def longestWord(words: Array[String]) = {
      var word = words(0)
      var idx = 0
      for (i <- 1 until words.length)
        if (words(i).length > word.length) {
          word = words(i)
          idx = i
        }
      (word, idx)
    }
    //making a function that puts word into a tuple

    val longest = longestWord("The quick brown fox".split(" "))
    //useing logestWord to turn a string into one

    //do imutable examples follow the mutable example for that.
    //do it again
    //you can do everting with imutable
    //why they use imutable and mutable

    //some thing to do with Multithreading
    //val words2 = mutable.Set.empty[String]
    val numbers2 = List(1, 2, 3)
    val test = Set(1, 2, 3)
    val test2 = Map(1 -> 2, 3 -> 4)

    //this is immutable value using var
    var authorized = Set("Nancy", "Jane")

    authorized += "Bill"

    println(authorized)

    authorized -= "Jane"

    println(authorized)


  }
}