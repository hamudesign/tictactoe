package design.hamu

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BoardSpec extends AnyWordSpec with Matchers {
  "Board" should {
    val b = Board.initFreshBoard
    "produce a fresh board when evoked" in {
      b.stringify() must equal("___\n___\n___")
    }

    val bOneMove = b.move(1, 1, 'X')
    "respond to a requested move" in {
      bOneMove.stringify() must equal("___\n_X_\n___")
    }

    "return a requested space" in {
      bOneMove.get(1, 1) must equal('X')
    }

    "respect immutability" in {
      b.stringify() must equal("___\n___\n___")
    }
  }
}
