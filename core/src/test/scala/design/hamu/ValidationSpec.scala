package design.hamu

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ValidationSpec extends AnyWordSpec with Matchers {

    "Validation" should {
        val board = Board.initFreshBoard
        val m1 = board.move(0, 0, 'X')
        val m2 = m1.move(0, 1, 'X')
        val m3 = m2.move(0, 2, 'X')
        " produce vertical winner " in {
            //   Y
            //   ^
            // 2 | X _ _
            // 1 | X _ _
            // 0 | X _ _
            //   +-------> X
            //     0 1 2
            Validation.isWinner(m3, 0, 2) must equal(true)

        }
        //   Y
        //   ^
        // 2 | X X X
        // 1 | _ _ _
        // 0 | _ _ _
        //   +-------> X
        //     0 1 2
        val board2 = Board.initFreshBoard;
        val m1b2 = board2.move(2, 2, 'X')
        val m2b2 = m1b2.move(1, 2, 'X')
        val m3b2 = m2b2.move(0, 2, 'X')
        "produce horizontal winner " in {
            Validation.isWinner(m3b2, 0, 2) must equal(true)
        }
        //   Y
        //   ^
        // 2 | _ _ O
        // 1 | _ O _
        // 0 | O _ _
        //   +-------> X
        //     0 1 2
        val board3 = Board.initFreshBoard;
        val m1b3 = board3.move(2, 2, 'O')
        val m2b3 = m1b3.move(1, 1, 'O')
        val m3b3 = m2b3.move(0, 0, 'O')
        "produce diagonal winner " in {
            Validation.isWinner(m3b3, 1, 1) must equal(true)
        }

        //   Y
        //   ^
        // 2 | O _ _
        // 1 | _ O _
        // 0 | _ _ O
        //   +-------> X
        //     0 1 2
        val board4 = Board.initFreshBoard;
        val m1b4 = board4.move(0, 2, 'O')
        val m2b4 = m1b4.move(1, 1, 'O')
        val m3b4 = m2b4.move(2, 0, 'O')
        "Other Diagonal Validation isWinner " in {
            Validation.isWinner(m3b4, 1, 1) must equal(true)
        }
    }
}
