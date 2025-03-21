package org.programingscala.chapter04
import scala.collection.mutable.Map

object Chapter04
{   
    class ChecksumAccumulator 
        {
            //here is how you make the varable private 
            //so you can only acces inside the class
            //private var sum = 0
            var sum = 0

            def add(b: Byte): Unit = {
                sum += b 
            }

            def checksum(): Int ={    
                //this returns a bite wise object
                ~(sum & 0xFF) + 1 
            }
        }

    def step13(): Unit =
    {
        val acc = new ChecksumAccumulator
        val csa = new ChecksumAccumulator

        println("acc sum: " + acc.sum)
        println("csa sum: " + csa.sum)
        //you can mutate the varable inside the acc and csa 
        //even if they are a val because in the class def the sum is a var
        //but what you cant do here is reasign acc into a nother ChecksumAccumulator class
        //acc = new ChecksumAccumulator
        acc.sum = 4
        csa.sum = 5
    }

    def step14(): Unit =
    {
        //here is how you write two statement in one line
        val s: String = "hello"; println(s)
        var v: Int = (1
        + 1
        + 2)
        print(v)
    }

    def step15(): Unit = 
    {
        var i: Int = 1
        // only i in scope here
        while(i <= 10)
        {
            var j = 1
            // both i and j in scope here
            while(j <= 10)
            {
                val prod =(i*j).toString
                // i, j, and prod in scope here
                var k = prod.length
                // i, j, prod, and k in scope here
                while(k<4)
                {
                    print(" ")
                    k += 1
                }
                print(prod)
                j += 1
            }
            // i and j still in scope; prod and k out of scope
            println()
            i += 1
        }
        // i still in scope; j, prod, and k out of 

        val a = 1; 
            {
            val a = 2 // Compiles just fine
            println(a) 
            }
        println(a)
    }
    
    def step16(): Unit =
    {
        var checksum: Int = ChecksumAccumulator.calculate("jinghong")
        println(checksum)
    }

    object ChecksumAccumulator {
        private val cache = Map[String, Int]()

        def calculate(s: String): Int = {
            if (cache.contains(s))
                cache(s)
            else {
                val acc = new ChecksumAccumulator
                for (c <- s){
                    acc.add(c.toByte)
                }
                val cs = acc.checksum()
                cache += (s -> cs)
                cs
            }
        }
    }   

}   

//companion object
