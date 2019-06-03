package ir.ashkan.element

object Main extends App {
  implicit def fromChar(ch: Char): Element = Element(ch)

  //  val ashV = ('A' above 's' above 'h') beside ('A' above 's' above 'h') beside ('A' above 's' above 'h')
  val ashH = Element("Ashkan") above Element("Yasman") above Element("Grandma")
  val yasaman = Element("Yasaman")


  println(
    Box.Round(ashH) beside
      Box.Single(ashH) beside
      Box.Double(ashH) beside
      Box.Thick(ashH) beside
      Box.Dotted3Thin(ashH) beside
      Box.Dotted2Thin(ashH) beside
      Box.Dotted1Thin(ashH) beside
      Box.Dotted3Thick(ashH) beside
      Box.Dotted2Thick(ashH) beside
      Box.Dotted1Thick(ashH) beside
      Box.RoundDotted(ashH)
  )

  //   joins

  import Box2.Implicits._
  println(
    Box2.Double(ashH).above(Box2.Round(ashH)) beside
    (Box2.Double(ashH) above Box2.Double(ashH)) /*beside
    //      (Box2.Double(ashH) above Box2.Round(ashH))*/
  )

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
