package design.hamu

class Input(var inputPosition: String, var board: Board, var player: Player) {

  val x: Int = inputPosition.toInt % 3
  val y: Int = (inputPosition.toInt - x)/3

  def isValid : Boolean = {
    board.get(x, y) == '_'
  }

  def updateBoard(): Board = {
    board.move(x, y, player.piece)
  }

}
