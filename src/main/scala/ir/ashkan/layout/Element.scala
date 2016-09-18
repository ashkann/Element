package ir.ashkan.layout

abstract class Element {
  val content: Array[String]

  val height = content.length
  val width = if(content.nonEmpty) content.map(_.length).max else 0

  def above(that: Element) = Element(this.content ++ that.content)
  def beside(that: Element) = (this zip that){this.pad(_) + that.pad(_)}

  def map(f:String=>String) = Element(content.map(f))
  private def zip(that: Element)(f: (String, String) => String) = Element(this.content.zipAll(that.content,"","").map(x=>f(x._1,x._2)))
  private def pad(row:String) = row.padTo(width,Element.Space)

  override def toString = content mkString "\n"
}


object Element {
  class BitmapElement (val content: Array[String]) extends Element
  val Space = '\u0020'

  val Nil:Element = new BitmapElement(Array.empty)

  implicit def toElementOps(e:Element):ElementOps = new ElementOps(e)
  //  implicit def charToElement(ch:Char):Element = this(ch)

  def apply(text: String): Element = this(Array(text))
  def apply(ch: Char, w: Int, h: Int = 1): Element = this(Array.fill(h)(ch.toString * w))
  def apply(ch: Char): Element = this(Array(ch.toString))
  def apply(raw:Array[String]): Element = new BitmapElement(raw)

  def beside(es:Seq[Element]): Element = es.foldRight(Element.Nil){ _ beside _ }
}
