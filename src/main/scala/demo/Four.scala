package demo

case class BetterBasic(i: Int, name: String) {
  val doubleI: Int = 2 * i   // Evaluates the expression once
  def doubleEye: Int = 2 * i // Evaluates the expression each time it is called
}

// Companion objects are like Java classes with only static methods
object BetterBasic { // Companion object to BetterBasic case class
  def apply(i: Int): BetterBasic = i match {
    case 0 ⇒ BetterBasic(i,"Zero")
    case 1 ⇒ BetterBasic(i, "One")
    case v if v > 0 ⇒ BetterBasic(i, "Many")
    case _ ⇒ BetterBasic(i, "Negative")
  }
}

@main def four() =

  val bb = BetterBasic(1, "One")
  println(s"${bb.i}, ${bb.name}, ${bb.doubleI}, ${bb.doubleEye}")

  val bb2 = BetterBasic(4) // Calls apply method in BetterBasic object
  println(bb2) // BetterBasic(4, "Many")

  println("Hello World!")
