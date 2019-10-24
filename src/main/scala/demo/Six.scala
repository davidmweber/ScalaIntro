/*
 * Simple shape demonstration with Scaladoc
 */
package demo

/**
  * A single point in a Euclidian coordinate system
  * @param x X coordinate
  * @param y Y coordinate
  */
case class Coord(x: Double, y: Double) {

  /**
    * Addition operator which allows operations like this:
    * {{{
    *   val c = Coord(1,3) + Coord(2,-1) // Coord(3,2)
    * }}}
    */
  def +(that: Coord): Coord = Coord(this.x + that.x, this.y + that.y)
}

/**
  * Base class for all shapes
  */
sealed trait Shape {

  /**
    * Shapes can generate a spatially translated version of themselves
    * @param t The translation value
    * @return A new instance of the original shape translated in position
    */
  def translate(t: Coord): Shape
}

/**
  * A simple point
  * @param pos Location of the point
  */
case class Point(pos: Coord) extends Shape {
  def translate(t: Coord): Point = Point(pos + t)
}

/**
  * A circle shape
  * @param center Center of the circle
  * @param radius Radius
  */
case class Circle(center: Coord, radius: Double) extends Shape {
  def translate(t: Coord): Circle = Circle(center + t, radius)
}

/**
  * A polygon is a list of [[Coord]] indicating the vertices of the polygon
  * @param vertices The vertices
  */
case class Polygon(vertices: List[Coord]) extends Shape {
  def translate(t: Coord): Polygon = Polygon(vertices.map(c => c + t))
}

object Six {

  // Heterogeneous list of shapes
  val shapes = List[Shape](
    Point(Coord(0.0, 1.0)),
    Circle(Coord(1.0, 1.0), 1.0),
    Polygon(List(Coord(1.0, 1.0), Coord(2.0, 2.0), Coord(1.0, 2.0)))
  )

  def main(args: Array[String]): Unit = {

    shapes.foreach { // Pattern matching FTW!
      case Point(c)     => println(s"Point at (${c.x}, ${c.y})")
      case Circle(c, r) => println(s"Circle at (${c.x}, ${c.y}) with radius $r")
      case Polygon(v)   => println(s"Polygon with ${v.length} vertices")
    }

    println(shapes)
    // Translate the position of all the shapes in the list
    println(shapes.map(_.translate(Coord(1.0, 1.0))))
  }
}
