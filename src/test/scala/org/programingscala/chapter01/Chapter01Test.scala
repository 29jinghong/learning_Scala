package org.programingscala.chapter01
import org.scalatest.flatspec.AnyFlatSpec
import org.programingscala.chapter01.Chapter01

class Chapter01Test extends AnyFlatSpec {
    //testing the add function in chapter01
    "add function" should "add two positive Int" in {
        assert(Chapter01.add(20, 30) === 50)
    }
    it should "add two negitive Int " in {
        assert(Chapter01.add(-20, -30) === -50)
    }
    it should "add one negitive Int and one positive Int" in{
        assert(Chapter01.add(-20, 30) === 10)
    }

    //testing the sayHello function in chapter01
    "sayHello function" should "format the age and name" in{
        assert(Chapter01.sayHello("jinghong", 21) === (s"Hello said from jinghong at the age of: 21"))
    }

    //testing the max function in chapter01
    "max function" should "find the max in two positive Int" in{
        assert(Chapter01.max(100, 10) === 100)
    }

    it should "find the max in two negitive Int" in{
        assert(Chapter01.max(-10, -100) === -10)
    }

    it should "find the max in one negitive Int and one possitive Int" in{
        assert(Chapter01.max(-100, 100) === 100)
    }
}
