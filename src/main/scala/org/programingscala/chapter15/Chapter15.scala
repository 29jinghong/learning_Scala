package org.programingscala.chapter15

sealed trait Expr
//sealed trait can't be extended out side of this class

//ADT algebra data type
//hase a sum type and a product type
//sum type- how many kind of the expression you have(Var, Number, UnOp, BinOp, Null)
//product type - you combine 0-many types into one type

//patern matching starts with the key word case
////nextt followed with one or more expressions
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right:Expr) extends Expr
case object Null extends Expr

object Test {
  val varX = Var("x")

  def simplifyTop(expr: Expr): Expr =
    expr match {
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("*", e, Number(1)) => e
      case BinOp("+", Number(0), e) => e
      case BinOp("*", Number(1), e) => e
      case BinOp("+", Number(x), Number(y)) => Number(x + y)
      case BinOp("+", Var(a), Var(b)) => Var(a + b)
      case BinOp("+", x, y) if x == y  => BinOp("*", x, Number(2))
      case _ => expr
      //this catches any thing else and return expr
    }

  def printer(expr: Expr) = expr match {
    case b: BinOp => println(b)
//    case b @ BinOp("+", e, Number(0)) => println(b)
    case x: Var => println(x)
    case n: Number => println(n)
    case u: UnOp => println(u)
    case Null => println(Null)
  }
//this is wildcard which means any value can be input as _
//is the above like if it matches BinOp then println else case _ =>?

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }
//this is constants basicaly like if it is a then return b

  def f(x: Int): String = x match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }
//this is a example of varibales

  def sequence(x: BinOp): Unit = x match{
    case BinOp("0", _, _) => println("found it")
//    case BinOp("0", _*) => println("found it")
//    this will not work^(276)
    case _ => println("dident find it")
  }

//  this makes it so that you dont have to say how long the sequance is^
//
//  ("hello", 10, true) match {
//    case (word, idx, bool)  =>  // use word, idx and bool here...
//  }
//  this is how you match tuples
// what is word / idx / bool?

//any type matching
  def generalSize(x: Any) = x match{
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?" }

  val x: String = show(capitals get "Japan")
  print(x)

  val mytuple = (123, "abc")

  val (number, string) = mytuple

  val second: PartialFunction[List[Int],Int] = {
    case x :: y :: _ => y
  }

//for ((country, city) <- capitals)
//this is a for expression it loops for every capitals there is and gets country and city in it.
}
