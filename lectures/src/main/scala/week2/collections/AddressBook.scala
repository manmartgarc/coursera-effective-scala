package week2.collections

case class AddressBook(contacts: List[Contact])
case class Contact(name: String, email: String, phoneNumbers: List[String])

object AddressBook:
  val alice = Contact("Alice", "alice@sca.la", List())
  val bob = Contact("Bob", "bob@sca.la", List("+41787829420"))
  val addressBook = AddressBook(List(alice, bob))
