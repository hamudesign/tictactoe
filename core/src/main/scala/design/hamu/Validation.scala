package design.hamu
//  Singleton?
object Validation {
    def isMoveValid(currentBoard : Board, x : Int , y : Int ): Boolean = {
         if (currentBoard.get(x,y) == '_') // Blank Space - Taylor Swift
           true
         else
           false
    }
    def horizontalCheck(currentBoard : Board , y : Int): Boolean = {
        var vectorOfChars = Vector[Char]()
        for (col <- 0 to 2) {
            vectorOfChars = vectorOfChars :+ currentBoard.get(col,y)
        }
        vectorOfChars.distinct.length == 1
    }
    def verticalCheck(currentBoard : Board , x : Int): Boolean = {
        var vectorOfChars = Vector[Char]()
        for (row <- 0 to 2) {
            vectorOfChars =  vectorOfChars :+ currentBoard.get(x,row)
        }
        vectorOfChars.distinct.length == 1
    }
    
    def diagonalBotToTopCheck(currentBoard : Board, x : Int, y : Int ): Boolean = {
        if (x == y) {
            var vectorOfChars = Vector[Char]()
            for (xy <- 0 to 2) {
                vectorOfChars = vectorOfChars :+ currentBoard.get(xy, xy)
            }
            vectorOfChars.distinct.length == 1
        } else {
            false
        }
    }

    def diagonalTopToBotCheck(currentBoard : Board, x : Int, y : Int ): Boolean = {
        if ((x + y) == 2 ) {
            var vectorOfChars = Vector[Char]()
            for (xy <- 0 to 2) {
                vectorOfChars = vectorOfChars :+ currentBoard.get(xy, 2-xy)
            }
            vectorOfChars.distinct.length == 1
        } else {
            false
        }
    }
    
    def isWinner (currentBoard : Board, x : Int, y : Int ): Boolean = {
      (horizontalCheck(currentBoard, y) || verticalCheck(currentBoard, x) || diagonalBotToTopCheck(currentBoard, x, y) || diagonalTopToBotCheck(currentBoard, x, y))
    }

}
