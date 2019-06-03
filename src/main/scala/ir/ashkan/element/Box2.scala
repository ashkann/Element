package ir.ashkan.element

import ir.ashkan.element.Box.{Decoration, bottomLeft, bottomRight, horizontalEdge, solidDouble, topLeft, topRight, verticalEdge}

import scala.language.implicitConversions

class BoxedElement[+B <: Box2](val box: Box2, val inner: Element) extends Element {

  def above[B2 <: Box2, R <: Box2](that: BoxedElement[B2])(implicit above: Box2.Above[B, B2, R]): BoxedElement[R] = above.above(this, that)

  //  def beside[B2 <: Box2](that: BoxedElement[B2])(implicit ev: Box2.CollapsibleWith[B, B2]): BoxedElement[this.box.type] = box(this.inner beside that.inner)
  //
  //  override def beside(that: Element): Element = super.beside(that)

  override val content: Array[String] = materialized.content
  override val width: Int = materialized.width

  // @todo make private
  lazy val materialized: Element = box.materialize(inner)
}

class Box2(val decorations: Box.Decoration) extends Element.Decorator {

  def apply(content: Element): BoxedElement[this.type] = new BoxedElement(this, content)

  def materialize(content: Element): Element = {
    implicit def toElement(ch: Char): Element = Element(ch)

    val hEdge = Element(decorations(Box.horizontalEdge), content.width, 1)
    val vEdge = Element(decorations(Box.verticalEdge), 1, content.height)

    (decorations(Box.topLeft) beside hEdge beside decorations(Box.topRight)) above
      (vEdge beside content beside vEdge) above
      (decorations(Box.bottomLeft) beside hEdge beside decorations(Box.bottomRight))
  }
}

object Box2 {
  private val roundCorners: Decoration = Map(
    topLeft -> '\u256D',
    topRight -> '\u256E',
    bottomLeft -> '\u2570',
    bottomRight -> '\u256F'
  )
  private val doubleCorner: Decoration = Map(
    topLeft -> '\u2554',
    topRight -> '\u2557',
    bottomLeft -> '\u255a',
    bottomRight -> '\u255d',
  )

  private val solidThin: Decoration = Map(horizontalEdge -> '\u2500', verticalEdge -> '\u2502')
  private val solidDouble: Decoration = Map(horizontalEdge -> '\u2550', verticalEdge -> '\u2551')

  object NoBoxing extends Box2(Box.undecorated) {
    override def materialize(content: Element): Element = content
  }

  object Round extends Box2(solidThin ++ roundCorners)

  object Double extends Box2(solidDouble ++ doubleCorner)

  abstract class Above[-A <: Box2, -B <: Box2, Result <: Box2] {
    def above(a: BoxedElement[A], b: BoxedElement[B]): BoxedElement[Result]
  }

  trait Fallback {
    implicit def separate[A <: Box2, B <: Box2]: Above[A,B,NoBoxing.type] = (a, b) => NoBoxing(a.materialized above b.materialized)
//    implicit object SeparateBorder extends Above[Box2, Box2, NoBoxing.type] {
//      def above(a: BoxedElement[Box2], b: BoxedElement[Box2]): BoxedElement[NoBoxing.type] = NoBoxing(a.materialized above b.materialized)
//    }
  }

  object Implicits extends Fallback {
    implicit def collapse[B <: Box2]: Above[B, B, B] = (a, b) => a.box(a.inner above b.inner).asInstanceOf[BoxedElement[B]]
  }


  //
  //  implicit def collapse[B <: Box2]: Above[B,B,B] = new CollapseBorder[B]

  //
  //  class CollapsibleIsReflective[A <: Box2] extends (A Above A)
  //
  //  implicit object CollapsibleIsReflectiveForRound extends CollapsibleIsReflective[Box2.Round.type]
  //
  //  implicit object CollapsibleIsReflectiveForDouble extends CollapsibleIsReflective[Box2.Double.type]

}