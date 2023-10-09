case class AddressBook(contacts: List[Contact])
case class Contact(name: String, email: String, phoneNumbers: List[String])

val alice = Contact("Alice", "alice@sca.la", List())
val bob = Contact("Bob", "bob@sca.la", List("+41787829420"))
val addressBook = AddressBook(List(alice, bob))

val numberOfContacts: Int = addressBook.contacts.length
val isAliceInContacts: Boolean = addressBook.contacts.contains(alice)
val contactNames: List[String] = addressBook.contacts.map(c => c.name)
val contactsWithPhone: List[Contact] =
  addressBook.contacts.filter(c => c.phoneNumbers.nonEmpty)
