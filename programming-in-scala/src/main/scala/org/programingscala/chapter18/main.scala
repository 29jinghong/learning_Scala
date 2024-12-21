package org.programingscala.chapter18
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
    val account = BankAccount
    account deposit 100
    account withdraw 80
    println("account.getBalance")
    println(account.getBalance)
    println()


  }
}
