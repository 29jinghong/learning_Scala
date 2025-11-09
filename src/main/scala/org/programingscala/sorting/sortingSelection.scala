// Selection Sort Example

object SelectionSort extends App {

  // Selection Sort function
  def selectionSort(arr: Array[Int]): Unit = {
    val n = arr.length // Store the number of elements in the array

    // Outer loop: controls how many passes through the array
    for (i <- 0 until n - 1) {
      var minIndex = i // Assume the first unsorted element is the smallest

      // Inner loop: find the smallest element in the remaining unsorted part
      for (j <- i + 1 until n) {
        if (arr(j) < arr(minIndex)) {
          minIndex = j // Update index if a smaller element is found
        }
      }

      // Swap the found smallest element with the first unsorted element
      if (minIndex != i) {
        val temp = arr(i)
        println(s"Switching ${arr(minIndex)} with ${arr(i)}")
        arr(i) = arr(minIndex)
        arr(minIndex) = temp

        // Print the current state of the array after this swap
        println(arr.mkString(", "))
      }

      // Print the array after each full pass
      println(s"After pass ${i + 1}: ")
      println(arr.mkString(", "))
      println()
    }
  }

  // Using the Selection Sort function
  val numbers = Array(2, 9, 1, 5, 6, 10, 3, 6, 12, 4)
  println("Before sorting: ")
  println(numbers.mkString(", "))

  selectionSort(numbers)

  println("After sorting:  ")
  println(numbers.mkString(", "))

  def selectionSortSteps(n: Int): Unit = {
    var total = 0
    for (i <- 1 until n) {
      val steps = n - i
      println(s"Pass $i: $steps comparisons")
      total += steps
    }
    println()
    println(s"Total comparisons: $total")
  }

  println()
  val n = numbers.length
  println(s"Calculating steps for Selection Sort with $n numbers:\n")
  selectionSortSteps(n)
}
