package org.programingscala.chapter18

object BankAccount {
  def apply(name: String): BankAccount = {
    require(name.nonEmpty, "Name is empty")
    new BankAccount(name)
  }
}

class BankAccount private(val name: String){
  private var balance: Int = 0

  def deposit(amount: Int): Unit = {
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

  override def toString: String = s"account name: $name, account amount: $balance"
}
