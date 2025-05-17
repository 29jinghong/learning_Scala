package org.programingscala.chapter22

object Buffer {
  "a" + "b" + "c" + "d" + "e"
  "ab" + "c" + "d" + "e"
  "abc" + "d" + "e"
  "abcd" + "e"
  "abcde"

  val sb = new StringBuilder("a")
  sb ++= "b"
  sb ++= "c"
  sb ++= "d"
  sb ++= "e"
  sb.toString()

  val x = scala.collection.mutable.Buffer()
}
