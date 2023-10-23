object UserID:
  opaque type UserID = Long
  def UserID(userID: String): UserID = userID.toLong
  extension (userID: UserID) def value: Long = userID

val myUserID = UserID.UserID("123")
UserID.value(myUserID)
// via the extension method
myUserID.value

// we can extend anything
extension (n: Int)
  def isZero: Boolean = n == 0
  def **(e: Int): Int = List.fill(e)(n).product

42.isZero
0.isZero
5 ** 3
// what the compiler actually sees
**(2)(4)

// if we call a method m on e of type E, like e.m, and the type
// E has no method m, the compiler rewrites the call into m(e)
// which is why this works.
isZero(42)