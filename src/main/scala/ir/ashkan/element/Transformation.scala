package ir.ashkan.element

abstract class Transformation extends (Element => Element)

object Transformation {
  implicit def lift(raw: Element => Element): Transformation = raw(_)

  val Transpose: Transformation = e => {
    def vertical(s: String): Element = s.map(Element(_)).reduce(_ above _)

    e.content.map(vertical).reduce(_ beside _)
  }
}