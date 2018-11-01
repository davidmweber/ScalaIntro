package demo

case class Coord(x: Double, y: Double) {
  def +(that: Coord): Coord = Coord(this.x + that.x, this.y + that.y)
}

sealed trait Shape {
  def translate(t: Coord): Shape
}

case class Point(pos: Coord) extends Shape {
  def translate(t: Coord): Point = Point(pos + t)
}

case class Circle(center: Coord, radius: Double) extends Shape {
  def translate(t: Coord): Circle = Circle(center + t, radius)
}

case class Polygon(vertices: List[Coord]) extends Shape {
  def translate(t: Coord): Polygon = Polygon(vertices.map(c => c + t))
}

object Six {

  // Heterogeneous list of shapes
  val shapes = List(
    Point(Coord(0.0, 1.0)),
    Circle(Coord(1.0,1.0), 1.0),
    Polygon(List(Coord(1.0,1.0), Coord(2.0,2.0), Coord(1.0, 2.0)))
  )

  def main(args: Array[String]): Unit = {

    shapes.foreach{ // Pattern matching FTW!
      case Point(c)     ⇒ println(s"Point at (${c.x}, ${c.y})")
      case Circle(c, r) ⇒ println(s"Circle at (${c.x}, ${c.y}) with radius $r")
      case Polygon(v)   ⇒ println(s"Polygon with ${v.length} vertices")
    }

    println(shapes)
    println(shapes.map(_.translate(Coord(1.0, 1.0))))

  }
}
