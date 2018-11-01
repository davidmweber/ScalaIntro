package demo

// More fun with functions
object Five {

  val square: Double ⇒ Double = (x: Double) ⇒ x * x
  val cube = (x: Double) ⇒ x * x * x
  println(square(3), cube(3))

  val t = List(1.0, 2.0, 3.0)
  println(t.map(square))
  println(t.map(cube)) // Cube
  println(t.map(_ * 2)) // Short cut for x => x * 2

  def main(args: Array[String]): Unit = { // Same as Java class with static public main....
    println("Hello World!")
  }
}
