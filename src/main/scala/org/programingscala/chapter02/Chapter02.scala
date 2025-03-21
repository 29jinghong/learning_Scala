package org.programingscala.chapter02

object Chapter02{
    def step4(name: String): Unit =
    {
        //figure out how to enter name as input and pring the name
        println(s"$name nice to meet you! my name is jinghong")
    }
    
    def step5(): Unit = 
    {
        //=====================while loop==============================
        println("this is a while loop:")
        var i: Int = 0
        var line: Int = 10
        while(i < line) {
            if (i != 0) 
                print(" ")
            println(s"Hi im line $i!")
            i += 1
        }
        println()
    }
    
    def step6(): Unit = 
    {
        //=======================foreach loop=============================
        println("This is a foreach loop")
        val numbers: List[Int] = List(1, 2, 3, 4)
        numbers.foreach(println)
        println()

        //===========================for loop=============================
        println("This is a for loop")
        val words: List[String] = List("hi", "we", "for")
        for (word <- words)
            println(word)
        println()
    }
}
