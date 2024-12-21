package org.programingscala.chapter18

object BankAccount {
  var balance: Int = 0

  def apply(): BankAccount = {
    new BankAccount
  }

  def deposit(amount: Int) {
    require(amount > 0, "Deposit amount must be greater than 0")
    balance += amount
  }

  def getBalance: Int = balance

  def withdraw(amount: Int): Boolean =
    if (amount <= balance) {
      balance -= amount;
      true
    }
    else false

}

class BankAccount {
}

class Keyed {
  def computeKey: Int = {
    123
  }
}

class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None

  override def computeKey: Int = {
    if (!keyCache.isDefined) keyCache = Some(super.computeKey)
    keyCache.get
  }
}
