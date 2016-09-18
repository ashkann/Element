package ir.ashkan.layout

object Main extends App {

//  val ashkan = Element("Ashkan")
  val Ash = Element('A') above Element('s') above Element('h') above Element('k') above Element('a') above Element('n')
//
//  val b1 = (
//    (Right(14) andThen Single)(ashkan) above
//      (Left(14) andThen Round)(ashkan)
//    ) above (
//    (Double compose Top(3))(ashkan) beside
//      (Thick compose Bottom(3))(ashkan)
//    )
//
//  val b2 = Single(Top(9)(Ash)) beside Single(Bottom(9)(Ash))

//  println(Thick(b1 beside b2) besideCollapse Thick(Ash))
//  println(Thick(b1 beside b2) besideCollapse Thick(Ash))
//  println(Thick(Ash) besideCollapse Thick(Ash))
  val id = (e:Element) => e

  new Transformation(id, Element("Ashkan"))
//  println(Transformation(id, Ash) beside Transformation(id,Ash))
}