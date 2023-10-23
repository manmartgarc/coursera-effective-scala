case class UserID private (value: Long)

object UserID:
  def parse(string: String): Option[UserID] =
    string.toLongOption.map(id => UserID(id))

UserID.parse("12345")
UserID.parse("a!b$")

// But the wrapper around a simple type can be expensive.
// Type aliases to the rescue!
type UserID2 = Long

object UserID2:
  def parse(string: String): Option[UserID2] =
    string.toLongOption

UserID2.parse("123")

// Opaque types offer the best of both worlds.

object UserID3:
  opaque type UserID3 = Long
  def parse(string: String): Option[UserID3] = string.toLongOption
  def value(userID: UserID3): Long = userID

UserID3.parse("123")
UserID3.value(UserID3.parse("123").get)
