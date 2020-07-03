package design.hamu
import scala.io.StdIn.readLine

object Main {

  def main(args: Array[String]): Unit = {
    println("Welcome to tic tac toe friends")
    println("Enter Player 1's name (X)")
    val playerOneName: String = readLine()
    println("Enter Player 2's name (O)")
    val playerTwoName: String = readLine()
    // Create our player pieces
    val playerOne = new Player(playerOneName, 'X')
    val playerTwo = new Player(playerOneName, 'O')

    val gameState = new Game()
    var board = Board.initFreshBoard
    while(gameState.isActive) {
      if (gameState.turn == 'X') {
        println(s"It is $playerOneName's turn, please give a value of 1-9 to place your piece")
        val inputPlayerOne = new Input(readLine(), board, playerOne)
        if (inputPlayerOne.isValid) {
          board = inputPlayerOne.updateBoard()
          gameState.turn = 'O'
        } else {
          println("This play is not valid")
        }
        println(board.stringify())
      } else if (gameState.turn == 'O') {
        println(s"It is $playerTwoName's's turn, please give a value of 1-9 to place your piece")
        val inputPlayerTwo = new Input(readLine(), board, playerTwo)
        if (inputPlayerTwo.isValid) {
          board = inputPlayerTwo.updateBoard()
          gameState.turn = 'X'
        } else {
          println("This play is not valid")
        }
        println(board.stringify())
      }
    }
  }
}
