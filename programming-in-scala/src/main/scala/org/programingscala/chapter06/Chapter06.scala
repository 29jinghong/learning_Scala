package org.programingscala.chapter06


object Chapter06
{
    class Rational(n: Int, d: Int)
    {
        require(d != 0)

        private val g = gcd(n.abs, d.abs)
        val numer = n / g
        val denom = d / g

        def this(n: Int) = this(n, 1)

        override def toString = n + "/" + d

        private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

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

    val oneHalf = new Rational(1, 2)

    val r = new Rational(1, 2)

    print(r.numer)

}