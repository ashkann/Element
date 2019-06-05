package ir.ashkan.element

abstract class Padding(len: Int) extends Transformation

object Padding {
  val Space = " "

  case class Left(len: Int) extends Padding(len) {
    def apply(e: Element): Element = e.map2(Space * len + _)
  }

  case class Right(len: Int) extends Padding(len) {
    def apply(e: Element): Element = e.map2(_ + Space * len)
  }

  case class Top(len: Int) extends Padding(len) {
    def apply(e: Element): Element = Element(Space +: e.content)
  }

  case class Bottom(len: Int) extends Padding(len) {
    def apply(e: Element): Element = Element(e.content :+ Space)
  }
}

