package ir.ashkan.element

object Main extends App {
  val e = Element("Ashkan") above Element("Yasman") above Element("Grandma")
  val yasaman = Element("Yasaman")

  println(
    Box.Round(e) beside
      Box.Single(e) beside
      Box.Double(e) beside
      Box.Thick(e) beside
      Box.Dotted3Thin(e) beside
      Box.Dotted2Thin(e) beside
      Box.Dotted1Thin(e) beside
      Box.Dotted3Thick(e) beside
      Box.Dotted2Thick(e) beside
      Box.Dotted1Thick(e) beside
      Box.RoundDotted(e)
  )

  def x(s: String): Seq[Element] = s.map(Element(_))


  //  class InverseStringElement(content:String) extends Element {
  //    override val content: Array[String] =
  //    override val width: Int = 1
  //  }

  println(
    Box.Single(e).mapContent(_.map(_ + "*")) beside
      Box.Double(e).mapContentWithIndex((s, n) => s"${n + 1}: $s") beside
      Box.Round(e).map(Transformation.Transpose)
  )

  //   joins

  //  println(
  //    LegoBox.above[LegoBox.Double.type ,LegoBox.Double.type,LegoBox.Double.type](LegoBox.Double(ashH),LegoBox.Double(ashH)),
  //    LegoBox.above[LegoBox.Double.type,LegoBox.Round.type,LegoBox.Round.type](LegoBox.Double(ashH),LegoBox.Round(ashH)) // type error
  //  )
  //  import LegoBox.Implicits._
  //  println(
  //    LegoBox.Double(ashH).above(LegoBox.Round(ashH)) beside
  //    (LegoBox.Double(ashH) above LegoBox.Double(ashH)) /*beside
  //    //      (Box2.Double(ashH) above Box2.Round(ashH))*/
  //  )

  //  println(Box2.Round(ashH).above(Box2.Round(ashH)) beside Box2.Round(ashH).above(Box2.Round(ashH)))

  //  case class B()
  //  case class A(b:B)
  //
  //  val b = B()
  //  val a1 = A(b)
  //  val a2 = A(b)
  //  implicitly[a1.b.type =:= a2.b.type]

  //  println ( Seq(Box.Single, Box.Double) )
  //  val c = Color.red
  //
  //  print( "Before  " + c(Element("Ashkan"))  + " After")
  //
  //    println(Box.Round(ashH).content.size)beside Box.Double(ashH)
  //    (Box.Round(ashH) beside Box.Double(ashH) beside Box.Single(ashH) beside Box.Thick(ashH)).content.foreach { x=>println (x.length) }
  //    val b1 = (

  //      (Right(14) andThen 11Single)(ash) above
  //        (Left(14) andThen Round)(ash)
  //      ) above (
  //      (Double compose Top(3))(ash) beside
  //        (Thick compose Bottom(3))(ash)
  //      )
  //    println(b1)
  //
  //
  //    val b2 = Single(Top(9)(Ash)) beside Single(Bottom(9)(Ash))
  //
  //    println(Thick(b1 beside b2) besideCollapse Thick(Ash))
  //    println(Thick(b1 beside b2) besideCollapse Thick(Ash))
  //    println(Thick(Ash) besideCollapse Thick(Ash))
  //    val id = (e:Element) => e
  //
  //    new Transformation(id, Element("Ashkan"))
  //    println(Transformation(id, Ash) beside Transformation(id,Ash))
}
