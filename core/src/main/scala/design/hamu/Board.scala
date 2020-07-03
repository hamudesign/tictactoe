package design.hamu

//   Y
//   ^
// 0 | _ _ _
// 1 | _ _ _
// 2 | _ _ _
//   +-------> X
//     0 1 2

class Board(val vecofvec: Vector[Vector[Char]]) {

  // public function. call to init a new board with a new vecofvec, with one change in the given coordinate.
  // returns same board with no changes if out of bounds
  def move(targetX: Int, targetY: Int, targetPiece: Char): Board = {
    val oldCol = vecofvec(targetY)
    val newCol = oldCol.updated(targetX, targetPiece)
    val newBoard = vecofvec.updated(targetY, newCol)
    new Board(newBoard)
  }

  // public function. call to retrieve the piece in a given coordinate.
  // returns tilde if out of bounds
  def get(x: Int, y: Int): Char = {
    vecofvec(y)(x)
  }

  def stringify(): String = {
    vecofvec(0).mkString+"\n"+vecofvec(1).mkString+"\n"+vecofvec(2).mkString
  }
}

object Board {

  // public function. inits a perfectly fresh board.
  def initFreshBoard: Board = {
    new Board( Vector.fill(3)(Vector.fill(3)('_')) )
  }
}
