package org.programingscala.chapter18

object Thermometer {
  def apply(name: String): Thermometer = {
    require(name.nonEmpty, "Missing Thermometer Name")
    new Thermometer(name)
  }

  def main(args: Array[String]): Unit = {

    val tThermometer = Thermometer("Frige thermometer")
    println("tThermometer.fahrenheit")
    println(tThermometer.fahrenheit)
  }
}

class Thermometer private(name: String){
  //the value of celsius it undefined which is a 0 in float by defult
  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32

  def fahrenheit_= (f: Float) {
    celsius = (f - 32) * 5 / 9
  }

  override def toString = fahrenheit +"F/"+ celsius +"C" + ", Name" + name
}
