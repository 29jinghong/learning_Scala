package org.programingscala.chapter06

//creating class called Rational
//which takes in two int numbers and create a 1/2 like fount
case class Rational(numer: Int, denom: Int)
{
    //makes sure that the denomnator is not 0
    require(denom != 0)

    def this(numer: Int) = this(numer, 1)

    override def toString = numer + "/" + denom

    ///gcd function                                       15,19%15
    def gcf(a: Int, b: Int): Int = if (b == 0) a else gcf(b, a % b)
    //println(gcd(6, 12))
    
    //need a function to simplyfy it 3/5 + 2/3 = 19/15
    def +(that: Rational): Rational = {
        val nNumer = numer * that.denom + that.numer * denom
        val nDenom = denom * that.denom
        val gcfNumber = gcf((nNumer), (nDenom))

        new Rational(nNumer / gcfNumber, nDenom / gcfNumber)
    }

    def *(that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    def lessThan(that: Rational) =
        this.numer * that.denom < that.numer * this.denom

    def max(that: Rational) =
        if (this.lessThan(that)) that else this
}
