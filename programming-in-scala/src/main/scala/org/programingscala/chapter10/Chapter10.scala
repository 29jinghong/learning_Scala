package org.programingscala.chapter10
import scala.io.Source

object Chapter10
{
    import Spiral.spiral
    def main(args: Array[String]): Unit = {
        val errMsg = "Please enter integer number of sides"
        val output =
        if (args.length == 0)
            errMsg
        else try {
            val nSides = args(0).toInt
            if (nSides < 1)
                "Please enter integer greater than zero"
            else
                spiral(nSides, 0)
        }
        catch {
            case e: NumberFormatException => errMsg
        }
        println(output)
    } 
}

object Element {
    private class ArrayElement(val contents: Array[String]) extends Element
    private class LineElement(s: String) extends Element {
        val contents: Array[String] = Array(s)
        override def width: Int = s.length
        override def height: Int = 1
    }
            
    private class UniformElement(
        ch: Char,
        override val width: Int,
        override val height: Int
        ) extends Element {
            private val line = ch.toString * width
            def contents = Array.make(height, line)
        }
        def elem(contents:  Array[String]): Element =
            new ArrayElement(contents)
        def elem(chr: Char, width: Int, height: Int): Element =
            new UniformElement(chr, width, height)
        def elem(line: String): Element =
            new LineElement(line)
}
