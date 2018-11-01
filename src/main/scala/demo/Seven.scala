/*
 * Now this is some advanced stuff. We handle exceptions using a Try monad. The
 * idea is to evaluate an expression and if it blows, bottle up the explosion
 * and roll it up into a wrapper for the detritus. Else just wrap the result in
 * a Success.
 */

package demo

import scala.util.control.NonFatal

abstract class Try[+T] // We will never instantiate a Try.

// Scala's way of building a constructor for a Try. Think of this as a Try factory
// It attempts to evaluate the "pass by name" expression and rolls up the result into
// the Try (Success if it works, Failure if it throws)_.
object Try {
  // The pass by name parameter is only evaluated when used....
  def apply[T](r: ⇒ T): Try[T] = {
    try Success(r) catch {
      case NonFatal(e) ⇒ Failure(e)
    }
  }
}

case class Success[+T](value: T) extends Try[T] // Our success wrapper
case class Failure[+T](exception: Throwable) extends Try[T]

object Seven {
  def main(args: Array[String]): Unit = {

    println(Try("123".toInt)) // Will succeed and print Success(123)
    println(Try("abc".toInt)) // Must fail with distressing news

    // Pattern matching.....
    Try("54321".toInt) match {
      case Success(v) ⇒ println(s"Success! $v")
      case Failure(e) ⇒ println(s"Error: ${e.getMessage}")
    }

    val strs = List("123", "234", "-123", "aa") // A Vodacom acceptable list of integers

    println(strs.map(s ⇒ Try(s.toInt)))

    // Or just go the full Monty on functional
    val ints = strs.map(s ⇒ Try(s.toInt)).collect{ case Success(i) ⇒ i }
    println(ints) // List(123, 234, -123)

  }
}
