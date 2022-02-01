package demo

// More fun with functions
@main def five() =
  val square: Double ⇒ Double = (x: Double) ⇒ x * x
  val cube: Double => Double = (x: Double) ⇒ x * square(x)
  println(s"{square(3)}, {cube(3)}")

  val t = List(1.0, 2.0, 3.0)
  println(t.map(square))
  println(t.map(cube)) // Cube
  println(t.map(_ * 2)) // Short cut for x => x * 2
