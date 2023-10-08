enum PrimaryColor:
  case Red, Blue, Green

def isProblematicForColorBlindPeople(color: PrimaryColor): Boolean =
  color match
    case PrimaryColor.Red   => true
    case PrimaryColor.Blue  => false
    case PrimaryColor.Green => true

isProblematicForColorBlindPeople(PrimaryColor.Red)

PrimaryColor.values
PrimaryColor.valueOf("Green")