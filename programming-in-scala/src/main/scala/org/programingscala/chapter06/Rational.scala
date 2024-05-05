package org.programingscala.chapter06


object Chapter06
{
        //creating class called Rational
        //which takes in two int numbers and create a 1/2 like fount
        class Rational(n: Int, d: Int)
        {
            //makes sure that the denomnator is not 0
            require(d != 0)
            
            //caculating the greatest common factor number
            private val g = gcd(n.abs, d.abs)
            val numer = n / g
            val denom = d / g

            def this(n: Int) = this(n, 1)

            override def toString = n + "/" + d

            ///gcd function
            def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
            //println(gcd(6, 12))
            
            def +(that: Rational): Rational = 
                new Rational(
                    numer * that.denom + that.numer * denom,
                        denom * that.denom
                    )

            def *(that: Rational): Rational =
                new Rational(numer * that.numer, denom * that.denom)

            def lessThan(that: Rational) =
                this.numer * that.denom < that.numer * this.denom

            def max(that: Rational) =
                if (this.lessThan(that)) that else this
        }
}
