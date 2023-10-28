import scala.Conversion
import scala.language.implicitConversions

sealed trait Json
case class JNumber(value: BigDecimal) extends Json
case class JString(value: String) extends Json
case class JBoolean(value: Boolean) extends Json
case class JArray(value: List[Json]) extends Json
case class JObject(value: (String, Json)*) extends Json
case class JsonField(json: Json)

object Json:
  def obj(fields: (String, JsonField)*): Json =
    JObject(fields.map((name, field) => (name, field.json))*)

object JsonField:
  given fromString: Conversion[String, JsonField] with
    def apply(s: String): JsonField = JsonField(JString(s))
  given fromInt: Conversion[Int, JsonField] with
    def apply(i: Int): JsonField = JsonField(JNumber(i))
  given fromBoolean: Conversion[Boolean, JsonField] with
    def apply(b: Boolean): JsonField = JsonField(JBoolean(b))
  given fromArray: Conversion[List[JsonField], JsonField] with
    def apply(a: List[JsonField]): JsonField = JsonField(JArray(a.map(_.json)))
  given fromJson: Conversion[Json, JsonField] with
    def apply(j: Json): JsonField = JsonField(j)

JObject("name" -> JString("Alice"), "age" -> JNumber(42))
var x = "hello"
x

// Finally the magic pays off
val y = Json.obj("name" -> "Alice", "age" -> 42)
y.equals(JObject("name" -> JString("Alice"), "age" -> JNumber(42)))
