package ir.ashkan.element

abstract class Decorator extends Transformation

class LazyDecorator(d: Decorator) extends Decorator {
  def apply(inner: Element) = new Decorated(inner, d)
}

class Decorated(e: Element, d: Decorator) extends Element {
  override val content: Array[String] = materialized.content
  override val width: Int = materialized.width
  private lazy val materialized = d(e)

  def map(f: Transformation) = new Decorated(f(e), d)

  def mapContentWithIndex(f: (String, Int) => String): Decorated = mapContent(_.zipWithIndex.map(f.tupled))

  def mapContent(f: Array[String] => Array[String]): Decorated = map(e => Element(f(e.content)))
}