package org.programingscala.chapter08
import scala.io.Source

object Chapter08
{
    def processFile(filename: String, width: Int): Unit ={
        def processLine(line:String): Unit ={
            if (line.length > width) print(filename+": "+line)
        }
        val source: Source = Source.fromFile(filename)
        for (line <- source.getLines) {
            processLine(line)
        }
    }
}
