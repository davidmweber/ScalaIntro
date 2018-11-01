package demo

// Expressions
object Two {

  // Vals and vars...
  val foo = 3
  println(foo)
  // foo = 4 // Compiler error: foo has an immutable reference

  var bar = 3
  bar = 4
  println(bar) // 4
  // bar = "123" // Compiler error: bar is an Int

  // Everything is an expression
  val thingOne = if (foo > 300) {
    "Biggish"
  } else {
    "Midget"
  }
  println(thingOne) // "Midget"

  val thingTwo = {
    val t = 20
    4 * t
  }
  println(thingTwo) // 80

  println{
    val a = 3
    val b = 4
    a + b
  } // 7

  def addNaturalNumbers(a: Int, b: Int): Int = {
    if (a < 0 || b < 0) throw new RuntimeException("Natural numbers must be positive and you supplied a negative number")
    a + b // No return statement needed
  }
  val r = addNaturalNumbers(2, 4)
  println(r) // 6

  val b = try addNaturalNumbers(-1, 3) catch {
    case e: Exception ⇒
      println(s"Error: ${e.getMessage}")
      0
  }
  println(b) // 0

  def main(args: Array[String]): Unit = {
    // What did Dave do here ?!!
  }

}



