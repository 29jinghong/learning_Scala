package org.programingscala.chapter14

import org.programingscala.chapter01.Chapter01 

object Chapter01Test {
    def main(args: Array[String]): Unit = {
        val num1: Int = 20
        val num2: Int = 30
        println("testing add function(20+30)......")
        assert(Chapter01.add(num1, num2) == 50)
        println("test passed!!!")
        
        val age1: Int = 21
        val name1: String = "jinghong"
        println("testing sayHello function(name: jinghong, age: 21)......")
        assert(Chapter01.sayHello(name1, age1) == (s"Hello said from $name1 at the age of: $age1"))
        println("test passed!!!")

        val num3: Int = 100
        val num4: Int = 10
        println("testing max function(100, 10)......")
        assert(Chapter01.max(num3, num4) == 100)
        println("test passed!!!")
    }
}