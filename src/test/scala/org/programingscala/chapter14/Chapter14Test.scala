package org.programingscala.chapter14

import org.scalatest.flatspec.AnyFlatSpec
import org.programingscala.chapter14.Caculator
//writen using The FlatSpec style
//specification text and tests line up flat against
//the left-side indentation level, with no nesting needed.

class Chapter14Test extends AnyFlatSpec {
    //testing the add function in chapter14
    "add function" should "add two positive Int" in {
        assert(Caculator.add(2, 3) === 5)
    }
    it should "add two negitive Int " in {
        assert(Caculator.add(-2, -3) === -5)
    }
    it should "add one negitive Int and one positive Int" in{
        assert(Caculator.add(-2, 3) === 1)
    }

    //testing the substract function in chapter14
    "substract function" should "substract two positive Int" in{
        assert(Caculator.substract(3, 4) === -1)
    }
    it should "substract two negitive Int" in{
        assert(Caculator.substract(-1, -4) === 3)
    }
    it should "substract one positive Int and one negitive Int" in{
        assert(Caculator.substract(3, -4) === 7)
    }
    
    //testing the mutiply function in chapter 14
    "mutiply function" should "mutiply two positive Int" in{
        assert(Caculator.mutiply(2, 2) === 4)
    }
    it should "mutiply two negitive Int" in{
        assert(Caculator.mutiply(-2, -2) === 4)
    }
    it should "mutiply one negitive Int and one positive Int" in{
        assert(Caculator.mutiply(-2, 2) === -4)
    }

    //testing the divide function in chapter 14
    "divide function" should "divide two positive Int" in{
        assert(Caculator.divide(2, 2) === 1)
    }
    it should "divide two negitive Int" in{
        assert(Caculator.divide(-2, -2) === 1)
    }
    it should "divide one negitive Int and one positive Int" in{
        assert(Caculator.divide(-2, 2) === -1)
    }
}
