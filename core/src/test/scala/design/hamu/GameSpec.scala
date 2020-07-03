package design.hamu

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameSpec extends AnyWordSpec with Matchers {
  "Game with an X on the (0, 0)" should {
    val board = Board.initFreshBoard
    var game = new Game(board, true, 'X')
    val coordinates = game.convertToCoordinates("4")
    game = game.input("4")
    "Coordinates should convert to" in {
      coordinates must equal((1, 1))
    }
    "If a coordinate exists, it should return false" in {
      game.isMoveValid("4") must equal(false)
    }
  }
}
