import scala.sys.Prop
case class Card(shape: Shape, number: Number, color: Color, shading: Shading)

enum Shape:
  case Diamond, Squiggle, Oval

enum Color:
  case Red, Green, Purple

enum Shading:
  case Open, Striped, Solid

enum Number:
  case One, Two, Three

enum Property:
  case Shape, Color, Shading, Number

val deck = List(
  Card(Shape.Diamond, Number.One, Color.Purple, Shading.Striped),
  Card(Shape.Squiggle, Number.Two, Color.Red, Shading.Open),
  Card(Shape.Oval, Number.Three, Color.Green, Shading.Solid)
)

def checkProperty(property: Property, cards: Card*): Boolean =
  cards.map(card => card.productElement(property.ordinal)).toSet.size != 2

def isValidSet(card1: Card, card2: Card, card3: Card): Boolean =
  checkProperty(Property.Shape, card1, card2, card3) &&
    checkProperty(Property.Number, card1, card2, card3) &&
    checkProperty(Property.Shading, card1, card2, card3) &&
    checkProperty(Property.Color, card1, card2, card3)

isValidSet(deck(0), deck(1), deck(2))