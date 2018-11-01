package demo

// Simple class
class Basic(i: Int, name: String) { // private attributes

  // Constructor initializing a public attribute
  val doubleI = i * 2

  // Methods
  def getI: Int = i
  def getName: String = name
  def getUpperCaseName: String = name.toUpperCase
}

object Three {

  def main(args: Array[String]): Unit = {
    val b = new Basic(1,"One")
    println(b.getName, b.doubleI) // ("One", 2)
  }
}
