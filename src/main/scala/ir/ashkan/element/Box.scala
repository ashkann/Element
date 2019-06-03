package ir.ashkan.element

import scala.language.implicitConversions

class Box(val decorations: Box.Decoration) extends Element.Decorator {

  def apply(content: Element): Element = {
    implicit def toElement(ch: Char): Element = Element(ch)

    val hEdge = Element(decorations(Box.horizontalEdge), content.width, 1)
    val vEdge = Element(decorations(Box.verticalEdge), 1, content.height)

    (decorations(Box.topLeft) beside hEdge beside decorations(Box.topRight)) above
      (vEdge beside content beside vEdge) above
      (decorations(Box.bottomLeft) beside hEdge beside decorations(Box.bottomRight))
  }
}

object Box {
  val right = '\u2571'
  val left = '\u2572'

  class Position

  val topLeft = new Position
  val topRight = new Position
  val bottomLeft = new Position
  val bottomRight = new Position
  val verticalEdge = new Position
  val horizontalEdge = new Position

  type Decoration = Map[Position, Char]

  val undecorated: Decoration = Map.empty[Position, Char]

  private val squareCorner: Decoration = Map(
    topLeft -> '\u250c',
    topRight -> '\u2510',
    bottomLeft -> '\u2514',
    bottomRight -> '\u2518',
  )
  private val roundCorners: Decoration = Map(
    topLeft -> '\u256D',
    topRight -> '\u256E',
    bottomLeft -> '\u2570',
    bottomRight -> '\u256F'
  )
  private val doubleCorner: Decoration = Map(
    topLeft -> '\u2554',
    topRight -> '\u2557',
    bottomLeft -> '\u255a',
    bottomRight -> '\u255d',
  )
  private val thickCorner: Decoration = Map(
    topLeft -> '\u250F',
    topRight -> '\u2513',
    bottomLeft -> '\u2517',
    bottomRight -> '\u251B',
  )
  private val solidThin: Decoration = Map(horizontalEdge -> '\u2500', verticalEdge -> '\u2502')
  private val solidThick: Decoration = Map(horizontalEdge -> '\u2501', verticalEdge -> '\u2503')
  private val solidDouble: Decoration = Map(horizontalEdge -> '\u2550', verticalEdge -> '\u2551')
  private val dotted3Thin: Decoration = Map(verticalEdge -> '\u250A', horizontalEdge -> '\u2508')
  private val dotted3Thick: Decoration = Map(verticalEdge -> '\u250B', horizontalEdge -> '\u2509')
  private val dotted2Thin: Decoration = Map(verticalEdge -> '\u2506', horizontalEdge -> '\u2504')
  private val dotted2Thick: Decoration = Map(verticalEdge -> '\u2507', horizontalEdge -> '\u2505')
  private val dotted1Thin: Decoration = Map(verticalEdge -> '\u254E', horizontalEdge -> '\u254C')
  private val dotted1Thick: Decoration = Map(verticalEdge -> '\u254F', horizontalEdge -> '\u254D')

  object Single extends Box(solidThin ++ squareCorner)

  object Dotted3Thin extends Box(squareCorner ++ dotted3Thin)

  object Dotted2Thin extends Box(squareCorner ++ dotted2Thin)

  object Dotted1Thin extends Box(squareCorner ++ dotted1Thin)

  object Thick extends Box(solidThick ++ thickCorner)

  object Dotted3Thick extends Box(thickCorner ++ dotted3Thick)

  object Dotted2Thick extends Box(thickCorner ++ dotted2Thick)

  object Dotted1Thick extends Box(thickCorner ++ dotted1Thick)

  object Double extends Box(solidDouble ++ doubleCorner)

  object Round extends Box(solidThin ++ roundCorners)

  object RoundDotted extends Box(roundCorners ++ dotted2Thin)

}