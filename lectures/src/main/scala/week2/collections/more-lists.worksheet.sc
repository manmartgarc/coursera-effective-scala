import week2.AddressBook

// Lists are recursive. Head :: Tail
val emptyList = Nil
val oneElement = 1 :: emptyList
val twoElement = 2 :: oneElement

val contacts1 = List("alice", "bob")
val contacts2 = "carol" :: contacts1

// :: operator is right-associative
List("alice", "bob") == "alice" :: "bob" :: Nil

// We can decompose lists with head :: tail syntax
AddressBook.addressBook.contacts match
  case contact :: tail => println(contact.name)
  case Nil             => println("No contacts")

// Here we are matching on a list of length 2
AddressBook.addressBook.contacts match
  case first :: second :: Nil => println(second.name)
  // Notice the wildcard matching pattern
  case _                      => println("Unexpected number of contacts")

val fruits = List("apples", "oranges", "pears")
fruits.head
fruits.tail
fruits.tail.head
// Random access IS NOT O(1) in Lists! This is why we have Vector :)
fruits(0)
fruits(2)