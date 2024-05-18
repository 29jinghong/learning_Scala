package org.programingscala.chapter06

import org.scalatest.flatspec.AnyFlatSpec

//people understand how to use your code by looking at your test

class RationalSpec extends AnyFlatSpec {

    //testing the Rational "+" function
    "Rational '+'" should "add two positive Rational numbers" in{
        val firstRational = new Rational(1, 2)
        val secondRational = new Rational(1, 2)

        val sum = firstRational + secondRational
        val expectedResult = new Rational(1, 1)

        assert(sum === expectedResult)
    }
    
    it should "add two negitive Rational numbers" in{
        val firstRational = new Rational(-1, -2)
        val secondRational = new Rational(-1, -2)

        val sum = firstRational + secondRational
        val expectedResult = new Rational(1, 1)

        assert(sum === expectedResult)
    }

    it should "add one negitive Rational number and one positvie Rational number" in{
        val firstRational = new Rational(-1, 2)
        val secondRational = new Rational(-1, 2)

        val sum = firstRational + secondRational
        val expectedResult = new Rational(-1, 1)

        assert(sum === expectedResult)
    }

    //testing the Rational "*" function
    "Rational '*'" should "times two positive Rational numbers" in{
        val firstRational = new Rational(3, 6)
        val secondRational = new Rational(3, 6)

        val sum = firstRational * secondRational
        val expectedResult = new Rational(9, 36)

        assert(sum === expectedResult)
    }

    it should "times two negivite Rational numbers" in{
        val firstRational = new Rational(-3, -6)
        val secondRational = new Rational(-3, -6)

        val sum = firstRational * secondRational
        val expectedResult = new Rational(9, 36)

        assert(sum === expectedResult)
    }

    it should "times one negivite Rational number and one positive Rational number" in{
        val firstRational = new Rational(-3, 6)
        val secondRational = new Rational(-3, 6)

        val sum = firstRational * secondRational
        val expectedResult = new Rational(9, 36)

        assert(sum === expectedResult)
    }

    it should "times one negitive Rational denom" in{
        val firstRational = new Rational(-3, 6)
        val secondRational = new Rational(3, 6)

        val sum = firstRational * secondRational
        val expectedResult = new Rational(-9, 36)

        assert(sum === expectedResult)
    }

    //testing Rational "lessThan" function
    "Rational 'lessThan'" should "find the least Rational number in two positive Rational number" in{
        val firstRational = new Rational(6, 6)
        val secondRational = new Rational(3, 6)

        //1 < 0.5
        val sum = firstRational.lessThan(secondRational)
        val expectedResult = false

        assert(sum === expectedResult)
    }
    
    it should "find the least Rational number in two negitive Rational number" in{
        val firstRational = new Rational(-6, -6)
        val secondRational = new Rational(-3, -6)

        //1 < 0.5
        val sum = firstRational.lessThan(secondRational)
        val expectedResult = false

        assert(sum === expectedResult)
    }

    it should "find the least Rational number in one positive Rational number and one negitive Rational number" in{
        val firstRational = new Rational(-6, -6)
        val secondRational = new Rational(3, 6)

        //1 < 0.5
        val sum = firstRational.lessThan(secondRational)
        val expectedResult = false

        assert(sum === expectedResult)
    }

    it should "find the least Rational number in two negitive numer Rational numbers" in{
        val firstRational = new Rational(-6, 6)
        val secondRational = new Rational(-3, 6)

        //-1 < -0.5
        val sum = firstRational.lessThan(secondRational)
        val expectedResult = true

        assert(sum === expectedResult)
    }

    //testing Rational "max" function
    "Rational 'max'" should "find the max of two positive Rational numbers" in{
        val firstRational = new Rational(6, 6)
        val secondRational = new Rational(3, 6)

        //1 vs 0.5
        val sum = firstRational.max(secondRational)
        val expectedResult = new Rational(6, 6)

        assert(sum === expectedResult)
    }

    it should "find the max of two negitive Rational numbers" in{
        val firstRational = new Rational(-6, -6)
        val secondRational = new Rational(-3, -6)

        //1 vs 0.5
        val sum = firstRational.max(secondRational)
        val expectedResult = new Rational(-6, -6)

        assert(sum === expectedResult)
    }

    it should "find the max of two negitive numer Rational numbers" in{
        val firstRational = new Rational(-6, 6)
        val secondRational = new Rational(-3, 6)

        //-1 vs -0.5
        val sum = firstRational.max(secondRational)
        val expectedResult = new Rational(-3, 6)

        assert(sum === expectedResult)
    }


}
