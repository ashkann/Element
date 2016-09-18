package ir.ashkan.layout

abstract class Padding(len:Int,how:(Int,Element)=>Element) extends (Element => Element) {
  override def apply(e: Element): Element = how(len,e)
}
case class Right(len:Int) extends Padding(len,Paddings.right)
case class Left(len:Int) extends Padding(len,Paddings.left)
case class Top(len:Int) extends Padding(len,Paddings.top)
case class Bottom(len:Int) extends Padding(len,Paddings.bottom)

private object Paddings {
  def right(len:Int,e:Element) = e.map { s"%-${len}s".format(_) }
  def left(len:Int,e:Element) = e.map { s"%${len}s".format(_)}
  def top(len:Int,e:Element) = Element(Array.fill(len-e.height)("") ++ e.content)
  def bottom(len:Int,e:Element) = Element(e.content.padTo(len,""))
}

