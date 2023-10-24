object Generator:
  var previous: Int = 42

  def nextInt(): Int =
    val result = previous * 22_695_477 + 1
    previous = result
    result

Generator.nextInt()
Generator.nextInt()
Generator.nextInt()

// immutable classes have a well defined identity
case class Rectangle(width: Int, height: Int)

Rectangle(3, 5) == Rectangle(3, 5)

// mutable classes are not, identity is defined by instance

class BankAccount:
  private var balance: Int = 0
  def deposit(amount: Int): Int =
    if amount > 0 then balance += amount
    balance

  def withdraw(amount: Int): Int =
    if amount > 0 && amount <= balance then balance -= amount
    balance

BankAccount() == BankAccount()
