package design.hamu

//   Y
//   ^
// 0 | _ _ _
// 1 | _ _ _
// 2 | _ _ _
//   +-------> X
//     0 1 2

class Board(var vecofvec: Vector[Vector[Char]]) {

  // public function. call to init a new board with a new vecofvec, with one change in the given coordinate.
  // returns same board with no changes if out of bounds
  def move(targetX: Int, targetY: Int, targetPiece: Char): Board = {
    try {
      val oldCol = vecofvec(targetY)
      val newCol = oldCol.updated(targetX, targetPiece)
      val newBoard = vecofvec.updated(targetY, newCol)
      new Board(newBoard)
    } catch {
      case x: IndexOutOfBoundsException => this
    }

  }

  // public function. call to retrieve the piece in a given coordinate.
  // returns tilde if out of bounds
  def get(x: Int, y: Int): Char = {
    try {
      vecofvec(y)(x)
    } catch {
      case x: IndexOutOfBoundsException => '~'
    }
  }

  def stringify(): String = {
    var out = ""
    for (y <- 0 to 2) {
      for (x <- 0 to 2) {
        out = out + this.get(x, y).toString
      }
      if (y != 2) {
        out = out + "\n"
      }
    }
    out
  }
}

object Board {

  // public function. inits a perfectly fresh board.
  def initFreshBoard: Board = {
    new Board(
      Vector(
        Vector('_', '_', '_'),
        Vector('_', '_', '_'),
        Vector('_', '_', '_')
      )
    )
  }
}
