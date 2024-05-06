package org.programingscala.chapter06

import org.scalatest.flatspec.AnyFlatSpec

//people understand how to use your code by looking at your test

class RationalSpec extends AnyFlatSpec {

    "Rational" should "add two positive Rational numbers" in{
        val oneHalf = new Rational(1, 2)
        val r = new Rational(1, 2)

        val sum = oneHalf + r
        val expectedResult = new Rational(1, 1)

        assert(sum === expectedResult)
    }
    
}
