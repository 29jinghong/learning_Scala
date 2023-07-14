package org.programingscala.chapter03
import scala.collection.mutable.HashSet
import scala.collection.mutable.HashMap
import scala.io.Source

object Chapter03{

    def step7(): Unit = 
        {
        //arrys are mutable
        var greetStrings: Array[String] = new Array[String](7)
        greetStrings(0) = "Hello"
        greetStrings(1) = ", "
        greetStrings(2) = "world!\n"
        greetStrings(3) = "Nice "
        greetStrings(4) = " to "
        greetStrings(5) = " meet "
        greetStrings(6) = " you!\n"

        for (i <- 0 to 6){
            print(greetStrings(i))
        }

        greetStrings.update(0, "Goodby")

        for (i <- 0 to 6){
        
            print(greetStrings(i))
        }

        val numNames = Array("zero", "one", "two")

        for (i <- 0 to 2){
            println(numNames(i))
        }

    }

    def step8(): Unit =
        {
            //Lists are immutable
            val days: List[String] = List("Monday", "Tuesday", "Wednestday", "Thrsday", "Friday", "Saturday")
            println(days)

            val allDays = days ::: List("Sunday") //concatnating two lists
            //val allDays = days ++ List("Sunday")
            
            val allDays2 = "Sunday" :: days //perpending to a list
            
            val allDays3 = days :+ "Sunday" //apending to a list 

            val xs = Set(1, 1, 2, 3)
            println(xs)
        }

    def step9(): Unit = 
    {
        val ageName = (20,"jinghongwang")// this is a tuple of two|tuple(int, str)|
        println(ageName._1)
        println(ageName._2)
    }

    def step10(): Unit = 
    {
        //=========================mutateable set===============================
        //for set you would need to import the HashSet
        val jetSet = new HashSet[String]//then you initiate the varable useing this fount

        jetSet += "Lear"//to add to the set you simply use the set name and "+=" to add new varables
        jetSet += ("Boeing", "Airbus")//this is how you would add two set
        println(jetSet)

        jetSet -= "Lear"//to delete from the set simply use "-="
        println(jetSet)
        //here
        
        //=======================immutateable set===============================
    
        //for immutateable set you would not need to import any kind of thing
        val movieSet = Set("Hitch", "Poltergeist", "Shrek")
        println(movieSet)

        //==========================mutateable map===============================
        //for mutateable map you would need to import scala.collection.mutable.HashMap
        val treasureMap = new HashMap[Int, String]// this is how you initiate hash map 
        treasureMap += (1 -> "Go to island.")//the -> returns a two element tuple containing key and value
        treasureMap += (2 -> "Find big X on ground.")
        treasureMap += (3 -> "Dig.")
        println(treasureMap(2))

        //==========================immutateable map==============================
        //for immutateable map you would not need to import any thing
        val romanNumeral = Map(
        1 -> "I",
        2 -> "II",
        3 -> "III",
        4 -> "IV",
        5 -> "V"
        )
        println(romanNumeral(4))
    }
    
    def step11(): Unit =
    {
        //origin loop with out
        var i = 0
        while (i < 3) {
            println(i)
            i += 1 }
        //or you can turn this entire code into a single line.    
        //args.foreach(println)
        //this removes all the extra lines that dont need, example:
        //you would not need the var i = 0,
        //then you would remove i+=1 too which removes 2 line
        //you can also change the enite loop ino a foreach loop.
        //val res = formatArgs(Array("zero", "one", "two")) 
        //assert(res == "zero\none\ntwo")
        //val answer = "res"
        //you can also use assert to check if the resoult maches
    }
    
    def step12():Unit = 
    {
        //this would need to import scala.io.Source
        //for (line <- Source.fromFile(args(0)).getLines)
            //print(line.length + " " + line)

         //the final version
    // def widthOfLength(s: String) = s.length.toString.length
    // if (args.length > 0) {
    // val lines = Source.fromFile(args(0)).getLines.toList
    // val widths = lines.map(widthOfLength)
    // val maxWidth = widths.reduceLeft((a, b) => a.max(b))
    // for (line <- lines) {
    //   val numSpaces = maxWidth - widthOfLength(line)
    //   val padding = " " * numSpaces
    //   print(padding + line.length + " " + line)
    // } }
    // else
    // Console.err.println("Please enter filename")
    }

    def test(x: Int)(y: Int): Int = x + y

    def testTwo(x: Int)(y: Int): Int = x * y

    val addOne: Int => Int = test(1) _

    val addTwo: Function1[Int, Int] = test(2) _
    //function curry

    List(1, 2, 3).map(addTwo)

    List(1, 2, 3).map(i => i + 2)


}

//defrerence bettwen hashset vs set, hashmap vs map(google this)
//hash function is computing the value into a hash and then compare the two hash to check if the value is the same

