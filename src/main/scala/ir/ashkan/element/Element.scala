package ir.ashkan.element

import scala.language.implicitConversions

abstract class Element {
  val content: Array[String]
  val width: Int
  final lazy val height: Int = content.length

  def above(that: Element): Element = Element.append(this, that)

  def beside(that: Element): Element = Element.zip(this, that) { case (l, r) => this.pad(l) + that.pad(r) }

  private def pad(row: String) = row.padTo(width, Element.Space)

  override def toString: String = content mkString "\n"
}

object Element {
  val empty: Element = this (Array.empty[String])

  class BitmapElement(val content: Array[String]) extends Element {
    private[this] val _width = if (content.nonEmpty) content.map(_.length).max else 0
    override val width: Int = _width
  }

  val Space = '\u0020'

  val Nil: Element = new BitmapElement(Array.empty)

  def apply(text: String): Element = this (Array(text))

  def apply(num: Int): Element = this (num.toString)

  def apply(ch: Char, w: Int, h: Int = 1): Element = this (Array.fill(h)(ch.toString * w))

  def apply(ch: Char): Element = this (Array(ch.toString))

  def apply(raw: Array[String]): Element = new BitmapElement(raw)

  def zip(left: Element, right: Element)(zipper: (String, String) => String): Element = this (left.content.zipAll(right.content, "", "").map { case (l, r) => zipper(l, r) })

  def append(above: Element, below: Element): Element = this (above.content ++ below.content)

  implicit def fromString(s: String): Element = this (s)

  implicit def fromInt(i: Int): Element = this (i)
}
