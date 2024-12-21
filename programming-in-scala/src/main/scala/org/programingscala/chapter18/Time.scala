package org.programingscala.chapter18

object Time {
  def apply(): Time = {
    new Time()
  }
}

class Time private {
  var h: Int = hour
  private[this] var m = 12

  def hour: Int = h

  def hour_=(x: Int) {
    require(0 <= x && x < 24);
    h = x
  }

  def minute = m

  def minute_=(x: Int) {
    require(0 <= x && x < 60);
    m = x
  }
}
