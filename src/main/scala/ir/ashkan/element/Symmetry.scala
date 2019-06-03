package ir.ashkan.element

import ir.ashkan.element.Element.Decorator

case class DecoratorProperty(t:Decorator)

//object A {
//  def a(t:Decorator)(ev: Relation(t))
//}

// prove a property holds
// predicate
case class A(s: Boolean) {
  class P
}

class P {
  case class A(s: Boolean)
}

object t extends P // a:t.A means a holds a true
object f extends P // a:f.A means a holds a false

object A extends App {
  def t(p:P)(a:p.A): p.A = p.A(!a.s)
}