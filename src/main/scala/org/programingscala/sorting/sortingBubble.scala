// Bubble Sort Example

object BubbleSort extends App {

  // Bubble Sort function
  def bubbleSort(arr: Array[Int]): Unit = {
    val n = arr.length // Store the number of elements in the array

    // Outer loop: controls how many passes through the array
    for (i <- 0 until n - 1) {
      // Inner loop: compares adjacent elements
      for (j <- 0 until n - i - 1) {
        // Compare current element with the next one
        if (arr(j) > arr(j + 1)) {
          // Swap elements if they are out of order
          val temp = arr(j)
          println(s"Switching $temp back 1 slot")
          arr(j) = arr(j + 1)
          arr(j + 1) = temp

          // Print the current state of the array after this swap
          println(arr.mkString(", "))
        }
      }

      // Print the array after each full pass
      println(s"After pass ${i + 1}: ")
      println(arr.mkString(", "))
      println()
    }
  }

  // Using the Bubble Sort function
  val numbers = Array(5, 2, 9, 1, 5, 6, 22, 3, 4, 7)
  println("Before sorting: ")
  println(numbers.mkString(", "))

  bubbleSort(numbers)

  println("After sorting:  ")
  println(numbers.mkString(", "))

  //calculating needed steps
  def bubbleSortSteps(n: Int): Unit = {
    var total = 0
    for (i <- 1 until n) {
      val steps = n - i
      println(s"Pass $i: $steps comparisons")
      total += steps
    }
    println()
    println(s"Max needed steps: $total")
  }
  println()

  val n = numbers.length
  println(s"Calculating steps for Bubble Sort with $n numbers:\n")
  bubbleSortSteps(n)
}

//find out if there is a way to do function sorting