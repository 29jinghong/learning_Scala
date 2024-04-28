package org.programingscala.chapter13

package p {
    class Super {
       def f(): Unit = { println("f") }
    }
    class Sub extends Super {
      f()
    }

    class Other {
      (new Super).f()  // error:  ‘f’ is not accessible
    }
}

package object p {
        type X = Int
        protected val g = 1
        class Food {
            val h = g
        }
    }

import p._

class Chap {
    val x: X = 1 
    val y = new Super()
    val z = new Super2()
    
    val w = new Food()
}

