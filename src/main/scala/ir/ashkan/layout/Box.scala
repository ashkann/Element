package ir.ashkan.layout

class Box
(
  topLeft: Char,
  topRight: Char,
  bottomLeft: Char,
  bottomRight: Char,
  horizontalEdge: Char,
  verticalEdge: Char
) extends (Element => Element)
{
  def apply(content:Element): Element = {
    implicit def toElement(ch:Char):Element = Element(ch)

    val hEdge = Element(horizontalEdge, content.width, 1)
    val vEdge = Element(verticalEdge, 1, content.height)

    (topLeft    beside  hEdge   beside topRight   ) above
    (vEdge      beside  content beside vEdge      ) above
    (bottomLeft beside  hEdge   beside bottomRight)
  }
}

object Single extends Box(
  topLeft = '\u250c',
  topRight = '\u2510',
  bottomLeft = '\u2514',
  bottomRight = '\u2518',
  horizontalEdge = '\u2500',
  verticalEdge = '\u2502'
)

object Double extends Box(
  topLeft = '\u2554',
  topRight = '\u2557',
  bottomLeft = '\u255a',
  bottomRight = '\u255d',
  horizontalEdge = '\u2550',
  verticalEdge = '\u2551'
)

object Round extends Box(
  topLeft = '\u256D',
  topRight = '\u256E',
  bottomLeft = '\u2570',
  bottomRight = '\u256F',
  horizontalEdge = '\u2500',
  verticalEdge = '\u2502'
)

object Thick extends Box(
  topLeft = '\u250F',
  topRight = '\u2513',
  bottomLeft = '\u2517',
  bottomRight = '\u251B',
  horizontalEdge = '\u2501',
  verticalEdge = '\u2503'
)
