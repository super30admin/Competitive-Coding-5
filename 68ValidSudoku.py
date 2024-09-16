"""
// Time Complexity :O(1) Size of sudoku board will remain same.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Compare row, column and board wise. 
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(0, 9):
            row_memory = {}
            for column in range(0, 9):
                element = (board[row][column])
                if board[row][column] != '.':
                    if element in row_memory:
                        return False
                    row_memory[element] = True

        for row in range(0, 9):
            column_memory = {}
            for column in range(0, 9):
                element = (board[column][row])
                if element != '.':
                    if element in column_memory:
                        return False
                    column_memory[element] = True
            print(column_memory)

        for block in range(0, 9):
            #Bool = [False] * 9
            block_memory = {}
            for i in range((block // 3 * 3), (block // 3 * 3 + 3)):
                for j in range(int(block % 3 * 3), int(block % 3 * 3 + 3)):
                    element = ord(board[i][j]) - ord('1')
                    if board[i][j] != '.':
                        if element in block_memory:
                            return False
                        block_memory[element] = True
        return True

if __name__ == "__main__":
  s = Solution()
  board = [
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
  print(s.isValidSudoku(board))
