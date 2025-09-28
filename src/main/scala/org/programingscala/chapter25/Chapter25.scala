package org.programingscala.chapter25

import scala.annotation.tailrec

object Chapter25 {
  def main(args: Array[String]): Unit = {
    // Example of deprecation
    @deprecated("Use saferAdd instead", "v1.0")
    def oldAdd(a: Int, b: Int): Int = a + b

    def saferAdd(a: Int, b: Int): Int = Math.addExact(a, b)

    // Example of volatile
    class SharedFlag {
      @volatile var running: Boolean = true
    }

    object AnnotationDemo extends App {
      //println(oldAdd(2, 3))
      // Will show a warning
      println(saferAdd(2, 3))
    }
  }
}
