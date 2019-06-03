package ir.ashkan.element

private object Padding {
  abstract class Padding(len:Int,how:(Int,Element)=>Element) extends Element.Decorator {
    override def apply(e: Element): Element = how(len,e)
  }
  case class Right(len:Int) extends Padding(len,Padding.right)
  case class Left(len:Int) extends Padding(len,Padding.left)
  case class Top(len:Int) extends Padding(len,Padding.top)
  case class Bottom(len:Int) extends Padding(len,Padding.bottom)
  
  def right(len:Int,e:Element): Element = e.map { s"%-${len}s".format(_) }
  def left(len:Int,e:Element): Element = e.map { s"%${len}s".format(_)}
  def top(len:Int,e:Element) = Element(Array.fill(len-e.height)("") ++ e.content)
  def bottom(len:Int,e:Element) = Element(e.content.padTo(len,""))
}

