import week2.collections.AddressBook.*

val namesAndSwissNumbers: List[(String, String)] =
  addressBook.contacts.flatMap(contact =>
    contact.phoneNumbers
      .filter(phoneNumber => phoneNumber.startsWith("+41"))
      .map(phoneNumber => (contact.name, phoneNumber))
  )

val namesAndSwissNumbersFor: List[(String, String)] =
  for
    contact <- addressBook.contacts
    phoneNumber <- contact.phoneNumbers
    if phoneNumber.startsWith("+41")
  yield (contact.name, phoneNumber)
