# Valid Sudoku

# Aprroach
# Create a row, col and grid set. For each i,j check if (board[i][j],i) is present in row. If yes, return False. 
# If No, if it not empty, add it to set. Similarly check for column set. FOr grid set, every 3:3 grid would have same answer after dividing it by 3. This will help us indentify the numbers in same grid
# If that number, row, col present in grid set, return False. If it is not empty, add it to the set. Return True

# Time Complexity: O(N**2)
# Space Complexity: O(N**2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m = len(board)
        n = len(board[0])
        row_set = set()
        col_set = set()
        grid_set = set()

        for i in range(m):
            for j in range(n):
                if (board[i][j],i) in row_set:
                    return False
                else:
                    if board[i][j] != ".":
                        row_set.add((board[i][j],i))
                if (board[i][j],j) in col_set:
                    return False
                else:
                    if board[i][j] != ".":
                        col_set.add((board[i][j],j))
                if (board[i][j],i//3,j//3) in grid_set:
                    return False
                else:
                    if board[i][j] != ".":
                        grid_set.add((board[i][j],i//3,j//3))
        return True