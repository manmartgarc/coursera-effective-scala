case class Contact(
    name: String,
    // common practice to label optional fields with maybe{field}
    maybeEmail: Option[String],
    phoneNumbers: List[String]
)

val alice = Contact("Alice", Some("alice@sca.la"), List())
val bob = Contact("Bob", None, List("+41787829420"))

def hasScaDotLaEmail(contact: Contact): Boolean =
  contact.maybeEmail match
    case None        => false
    case Some(email) => email.endsWith("@sca.la")

hasScaDotLaEmail(alice)
hasScaDotLaEmail(bob)

def emailLength(contact: Contact): Int =
  contact.maybeEmail.map(email => email.size).getOrElse(0)

emailLength(alice)
emailLength(bob)

val maybeAliceAndBobEmails: Option[(String, String)] =
  alice.maybeEmail.zip(bob.maybeEmail)

def sendSms(number: String, message: String): Unit =
  println(s"Sending $message to $number")

def sendEmail(email: String, message: String): Unit =
  println(s"Sending $message to $email")

def sendNotification(contact: Contact, message: String): Unit =
  contact.phoneNumbers.headOption match
    case Some(number) => sendSms(number, message)
    case None =>
      contact.maybeEmail match
        case None        => ()
        case Some(email) => sendEmail(email, message)

sendNotification(alice, "Hello!")
sendNotification(bob, "Hello!")
