package org.programingscala.chapter18

import org.programingscala.chapter18.MySimulation2.{halfAdder, probe, run}

object main{
  def main(args: Array[String]): Unit = {
    //Thermometer.scala
    val tThermometer: Thermometer = Thermometer("Frige thermometer")
    println("tThermometer.fahrenheit:")
    println(tThermometer.fahrenheit)
    println()

    //Time.scala
    val tTest: Time = Time()
    println("tTest.hour:")
    println(tTest.hour)
    println("tTest.minute:")
    println(tTest.minute)
    println()

    //BankAccount.scala
    val account = BankAccount("Jinghong Wang")
    account deposit 100
    account withdraw 80
    println("account.toString")
    println(account.toString)
    println()

    //Second name testing
    val account2 = BankAccount("Jason")
    println(account2.toString)
    account2 deposit 200
    println("account2.toString")
    println(account2.toString)
    println()




  }
}
