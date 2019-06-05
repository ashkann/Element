package ir.ashkan.element

//class BoxedElement[+B <: LegoBox](val box: LegoBox, val inner: Element) extends Element {
//
//  def above[B2 <: LegoBox, R <: LegoBox](that: BoxedElement[B2])(implicit above: LegoBox.Above[B, B2, R]): BoxedElement[R] = above.above(this, that)
//
//  //  def beside[B2 <: Box2](that: BoxedElement[B2])(implicit ev: Box2.CollapsibleWith[B, B2]): BoxedElement[this.box.type] = box(this.inner beside that.inner)
//  //
//  //  override def beside(that: Element): Element = super.beside(that)
//
//  override val content: Array[String] = materialized.content
//  override val width: Int = materialized.width
//
//  // @todo make private
//  lazy val materialized: Element = box.materialize(inner)
//}