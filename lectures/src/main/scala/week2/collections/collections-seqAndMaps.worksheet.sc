val data = List(
    "Alice" -> 42,
    "Bob" -> 30,
    "Werner" -> 77,
    "Owl" -> 6
)
data.sortBy((_, age) => age)
data.sortBy((name, _) => name)

val dataMap = Map("a" -> 0, "b" -> 1, "c" -> 2)
dataMap.get("a")
dataMap.get("z")

dataMap.withDefaultValue("No value found")("z")