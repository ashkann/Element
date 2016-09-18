package ir.ashkan.layout

abstract class Tr extends (Element=>Element)
abstract class Tr2[A] extends ((A,Element)=>Element)

class ElementOps(val e:Element) {
  def besideCollapse(right:Element):Element = {
    e beside(right)
  }

//  def isBoxed: Boolean =
}