package design.hamu

class Game(var board: Board, var isActive: Boolean, var turn: Char) {

  def convertToCoordinates(inputPosition: String): (Int, Int) = {
    (inputPosition.toInt % 3, (inputPosition.toInt - inputPosition.toInt % 3) / 3)
  }

  def isMoveValid(inputPosition: String): Boolean = {
    val (x, y): (Int, Int) = convertToCoordinates(inputPosition)
    board.get(x, y) == '_'
  }

  def input(inputPosition: String): Game = {
    val (x, y): (Int, Int) = convertToCoordinates(inputPosition)
    val b2 = board.move(x, y, turn)
    new Game(b2, isActive, if(turn == 'O') 'X' else 'O')
  }

}
