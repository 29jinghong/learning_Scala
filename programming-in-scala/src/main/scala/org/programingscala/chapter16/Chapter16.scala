package org.programingscala.chapter16

object Chapter16 {
    def main(args: Array[String]): Unit = {
        def easyPrint(x: String): Unit = {
            println("-----------------------------------------------")
            println()
            println()
            println(x + ":")
        }

        val ys: List[Int] = List(1, 2, 3)
        var sum: Int = 0

        for (i <- 1 to 3) {
            sum = sum + 1
        }

        val sum1 = ys.foldLeft(0) { case (accum, elem) => accum + elem }
        val prod = ys.foldLeft(1) { case (accum, elem) => accum * elem }

        val nums: List[Int] = List(1, 4, 3, 2, 6, 5, 7, 9, 8)
        easyPrint("A list of Int")
        println(nums)

        val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
        easyPrint("A list of list of Int")
        println(diag3)

        val empty: List[Nothing] = List()
        //all things in list have to be the same type

        val xs: List[String] = List()
        //you can do this because List[String] is under List()

        val fruit: List[String] = "apples" :: ("oranges" :: ("pears" :: Nil))
        //List("apples", "oranges", "pears")
        easyPrint("A list of fruit")
        println(fruit)

        val fruit2: List[String] = "apples" :: "oranges" :: "pears" :: xs
        fruit2 :+ "apples"
        easyPrint("Another list of fruit")
        println(fruit)

      //go step by step on this
        def isort(xs: List[Int]): List[Int] = {
            if (xs.isEmpty) Nil
            else{
                println(xs)
                insert(xs.head, isort(xs.tail))
            }
        }

        def insert(x: Int, xs: List[Int]): List[Int] =
            if (xs.isEmpty || x <= xs.head) x :: xs
            else{
                println(x, " ", xs)
                xs.head :: insert(x, xs.tail)
            }

        easyPrint("Running isort")
        println(isort(nums))

        easyPrint("Running insert")
        println(insert(13, nums))

        easyPrint("Running length function")
        println(nums.length)

        easyPrint("Running reverse function")
        println(nums.reverse)

        easyPrint("Running take function with input of 2")
        println(nums take 2)

        easyPrint("Running drop function with input of 2")
        println(nums drop 2)

        easyPrint("Running splitAt function with input of 2")
        println(nums splitAt 2)

        easyPrint("Running apply function with input of 2")
        println(nums apply 2)

        easyPrint("Running apply function with input of 2")
        println(nums(2))

        easyPrint("Running indices function")
        println(nums.indices)

        easyPrint("Running zip function")
        println(nums.indices.zip(nums))

        easyPrint("Running zipWithIndex function")
        println(nums.zipWithIndex)

        easyPrint("Running makeString function")
        println(nums.mkString ("[", ",", "]"))
        println(nums.mkString ("/", "/\\", "\\"))

        def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
            def merge(xs: List[T], ys: List[T]): List[T] =
                (xs, ys) match {
                    case (Nil, _) => ys
                    case (_, Nil) => xs
                    case (x :: xs1, y :: ys1) =>
                        if (less(x, y)) x :: merge(xs1, ys)
                        else y :: merge(xs, ys1)
                }
            val n = xs.length / 2
            if (n == 0) xs
            else {
                val (ys, zs) = xs splitAt n
                merge(msort(less)(ys), msort(less)(zs))
            }
        }

        easyPrint("Running msort")
        println(msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)))

        easyPrint("Running Find function")
        val testF =  List(-1, 2, 3, -4, 5) find (_ <= 0)
        //only finds and gets the first thing it touches
        println(testF)

        easyPrint("Running sort function")
        val testS = List(1, -3, 4, 2, 6).sortWith (_ < _)
        println(testS)
    }
}
