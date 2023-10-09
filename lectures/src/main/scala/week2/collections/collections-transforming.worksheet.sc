import scala.collection.mutable

import week2.AddressBook

val list = List(1, 2, 3, 4)
list.map(x => x + 1)

val buff = mutable.ArrayBuffer(1, 2, 3, 4)
buff.map(x => x % 2 == 0)

val map = Map(0 -> "No", 1 -> "Yes")
map.map((k, v) => k -> v * 2)

// flat map allows a n:m mapping where n <= m
List(1, 2, 3).flatMap(x => List())
mutable.ArrayBuffer(1, 2).flatMap(x => mutable.ArrayBuffer(x, x * 2))
Map(0 -> "zero", 1 -> "one").flatMap((k, _) => Map(k.toString -> k))

// wrong approach, returns a list of lists!
val allPhoneNumbers1 = AddressBook.addressBook.contacts.map(c => c.phoneNumbers)

// better approach, returns a single list
val allPhoneNumbers2 =
  AddressBook.addressBook.contacts.flatMap(c => c.phoneNumbers)

// the foldLeft method allows us to transform a collection into anything
// map and flatmap can only transform from collection to collection

// Sum the elements of the list
List(1, 2, 3).foldLeft(0)((acc, x) => acc + x)

// Reverse the list
List(1, 2, 3).foldLeft(List.empty[Int])((acc, x) => x +: acc)

// True if the last element is even or if the list is empty
List(1, 2, 3).foldLeft(true)((acc, x) => x % 2 == 0)

// methods can have more than one parameter list
def foo(x: Int, y: Int)(f: Int => Int): Int = f(x) + f(y)
foo(5, 3)(x => x)

// group elements of a collection by a partition function
val emails = List("alice@sca.la", "bob@sca.la", "carol@earth.world")
val domain: String => String =
  email => email.dropWhile(c => c != '@').drop(1)
val emailsByDomain = emails.groupBy(domain)
emailsByDomain("sca.la")
emailsByDomain("earth.world")