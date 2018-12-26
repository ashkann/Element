package ir.ashkan.element

/**
  * Created by ashkan on 9/18/16.
  */
class Transformation(tr:Element => Element, e: Element) extends Element {
  override val content: Array[ String ] = Array("A")
  //  override def beside(that: Element): Element = new Transformation(tr(_) beside that,e)
  //  override val content: Array[ String ] = tr(e).content
  override val width: Int = 12
}