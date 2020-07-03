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

    var game = new Game(Board.initFreshBoard, true, 'X')
    println("Possible board choices are")
    println("0|1|2")
    println("-----")
    println("3|4|5")
    println("-----")
    println("6|7|8")

    while (game.isActive) {
      if (game.turn == 'X') {
        println(s"It is $playerOneName's turn, please give a value of 0-8 to place your piece")
      } else if (game.turn == 'O') {
        println(s"It is $playerTwoName's's turn, please give a value of 0-8 to place your piece")
      }
      val move = readLine()
      if (game.isMoveValid(move)) {
        game = game.input(move)
      } else {
        println("This play is not valid")
      }
      println(game.board.stringify())
    }
  }
}
