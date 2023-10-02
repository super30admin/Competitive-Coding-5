# Time Complexity: O(1)
# Space Complexity:  O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [[False for _ in range(9)] for _ in range(9)]
        column = [[False for _ in range(9)] for _ in range(9)]
        square = [[False for _ in range(9)] for _ in range(9)]
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                val = board[i][j]
                
                if val == ".":
                    continue

                val = int(val)-1

                if row[i][val] == True:
                    return False
                row[i][val] = True
                
                if column[j][val] == True:
                    return False
                column[j][val] = True
                
                box = 3 * (i // 3) + j // 3
                if square[box][val] == True:
                    return False
                square[box][val] = True
                
        return True
