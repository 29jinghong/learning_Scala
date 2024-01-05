package org.programingscala.chapter10
import scala.io.Source
import Element.elem 

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
            def contents = Array.fill(height)(line)        
        }
        def elem(contents:  Array[String]): Element =
            new ArrayElement(contents)
        def elem(chr: Char, width: Int, height: Int): Element =
            new UniformElement(chr, width, height)
        def elem(line: String): Element =
            new LineElement(line)
}

abstract class Element {
    def contents: Array[String]
    def width: Int =
        if (height == 0) 0 else contents(0).length
    def height: Int = contents.length
    def above(that: Element): Element =
        elem(this.contents ++ that.contents)
    def beside(that: Element): Element =
        elem(
            for ((line1, line2) <- this.contents zip that.contents)
            yield line1 + line2
        )}
