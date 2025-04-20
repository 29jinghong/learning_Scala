package org.programingscala.chapter21

import PlayerHealth._

object Chapter21 {
  def main(args: Array[String]): Unit = {
    val battle = 100.hp
      .takeDamage(30)
      .heal(22)
      .takeDamage(90)

    println(battle) // Output: HP: 0
    println(battle.isAlive) // Output: false
  }
}
