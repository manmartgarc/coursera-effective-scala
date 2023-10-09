val data = List(1, 2, 3, 4)

// Notice the Option return type. It only returns the first one.
data.find(x => x % 2 == 0)
data.filter(x => x % 2 == 0)

data.find(x => x == 1)
data.find(x => x == 5)