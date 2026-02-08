// In this problem of valid sudoku, we need to check whether a given 9x9 Sudoku board is valid. We traverse the rows and columns of the board first using hashsets to check for duplicates.
// Then, we check each of the nine 3x3 sub-boxes for duplicates as well. If any duplicates are found in rows, columns, or boxes, we return false. If no duplicates are found, we return true.
// Time complexity is O(1) since the board size is fixed (9x9), and space complexity is also O(1) for the same reason.

class Solution {
    private var m = 0
    private var n = 0
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        m = board.size
        n = board[0].size

        if (m != 9|| n != 9) return false

        for (i in 0 until m) {
            val rowSet = mutableSetOf<Char>()
            val colSet = mutableSetOf<Char>()

            for(j in 0 until n) {

                val rowChar = board[i][j]
                if(rowChar != '.') {
                    if(rowChar in rowSet) return false
                    rowSet.add(rowChar)
                }

                val colChar = board[j][i]
                if(colChar != '.') {
                    if(colChar in colSet) return false
                    colSet.add(colChar)
                }
            }
        }

        if(!checkBoxes(board)) return false

        return true
    }

    fun checkBoxes(board: Array<CharArray>) : Boolean {
        for(startRow in 0 until m step 3) {
            for(startCol in 0 until n step 3) {
                val boxSet = mutableSetOf<Char>()

                for(r in startRow until startRow + 3){
                    for(c in startCol until startCol + 3) {
                        val ch = board[r][c]

                        if(ch != '.') {
                            if(ch in boxSet) return false
                            boxSet.add(ch)
                        }
                    }
                }
            }
        }
        return true
    }
}