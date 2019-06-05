package ir.ashkan.element

import ir.ashkan.element.Box.{Decoration, bottomLeft, bottomRight, horizontalEdge, solidDouble, topLeft, topRight, verticalEdge}

import scala.language.implicitConversions

//class LegoBox(val decorations: Box.D) extends Element.Decorator {
//
//  def apply(content: Element): BoxedElement[this.type] = new BoxedElement(this, content)
//
//  def materialize(content: Element): Element = {
//    implicit def toElement(ch: Char): Element = Element(ch)
//
//    val hEdge = Element(decorations(Box.horizontalEdge), content.width, 1)
//    val vEdge = Element(decorations(Box.verticalEdge), 1, content.height)
//
//    (decorations(Box.topLeft) beside hEdge beside decorations(Box.topRight)) above
//      (vEdge beside content beside vEdge) above
//      (decorations(Box.bottomLeft) beside hEdge beside decorations(Box.bottomRight))
//  }
//}

//object LegoBox {
//  private val roundCorners: Decoration = Map(
//    topLeft -> '\u256D',
//    topRight -> '\u256E',
//    bottomLeft -> '\u2570',
//    bottomRight -> '\u256F'
//  )
//  private val doubleCorner: Decoration = Map(
//    topLeft -> '\u2554',
//    topRight -> '\u2557',
//    bottomLeft -> '\u255a',
//    bottomRight -> '\u255d',
//  )
//
//  private val solidThin: Decoration = Map(horizontalEdge -> '\u2500', verticalEdge -> '\u2502')
//  private val solidDouble: Decoration = Map(horizontalEdge -> '\u2550', verticalEdge -> '\u2551')
//
//  object NoBoxing extends LegoBox(Box.undecorated) {
//    override def materialize(content: Element): Element = content
//  }
//
//  object Round extends LegoBox(solidThin ++ roundCorners)
//
//  object Double extends LegoBox(solidDouble ++ doubleCorner)
//
//  abstract class Above[-A <: LegoBox, -B <: LegoBox, Result <: LegoBox] {
//    def above(a: BoxedElement[A], b: BoxedElement[B]): BoxedElement[Result]
//  }
//
//  trait Fallback {
//    implicit def separate[A <: LegoBox, B <: LegoBox]: Above[A, B, NoBoxing.type] = (a, b) => NoBoxing(a.materialized above b.materialized)
//
//    //    implicit object SeparateBorder extends Above[Box2, Box2, NoBoxing.type] {
//    //      def above(a: BoxedElement[Box2], b: BoxedElement[Box2]): BoxedElement[NoBoxing.type] = NoBoxing(a.materialized above b.materialized)
//    //    }
//  }
//
//  object Implicits extends Fallback {
//    implicit def collapse[B <: LegoBox]: Above[B, B, B] = (a, b) => a.box(a.inner above b.inner).asInstanceOf[BoxedElement[B]]
//  }
//
////  def above[T, B, R <: LegoBox](top: BoxedElement[T], bottom: BoxedElement[B], brickie: (BoxedElement[T], BoxedElement[B]) => BoxedElement[R]): BoxedElement[R] = {
////    brickie(top, bottom)
////  }
//
////  def doubleOnTopOfDouble(top: BoxedElement[Double.type], bottom: BoxedElement[Double.type]): BoxedElement[Double.type] = {
////    Double(top.content above bottom.content)
////  }
//
//  //
//  //  implicit def collapse[B <: Box2]: Above[B,B,B] = new CollapseBorder[B]
//
//  //
//  //  class CollapsibleIsReflective[A <: Box2] extends (A Above A)
//  //
//  //  implicit object CollapsibleIsReflectiveForRound extends CollapsibleIsReflective[Box2.Round.type]
//  //
//  //  implicit object CollapsibleIsReflectiveForDouble extends CollapsibleIsReflective[Box2.Double.type]
//
//}