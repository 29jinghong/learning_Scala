package org.programingscala.chapter21

class PlayerHealth(val current: Int) {
  def takeDamage(amount: Int): PlayerHealth =
    new PlayerHealth((current - amount).max(0))

  def heal(amount: Int): PlayerHealth =
    new PlayerHealth(current + amount)

  def isAlive: Boolean = current > 0

  override def toString: String = s"HP: $current"
}

object PlayerHealth {
  implicit class IntToHealth(val hitpoint: Int) extends AnyVal{
    def hp: PlayerHealth = new PlayerHealth(hitpoint)
  }
}
