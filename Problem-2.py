# Time Complexity : O(mn)
# Space Complexity :O(mn)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Use HashSets to keep track of digits seen in each row, column, and 3x3 sub-box
# Traverse the board and for each non-empty cell, check for duplicates in row, column, and box
# If any duplicate is found return false; if traversal completes, return true

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        col = [set() for _ in range(9)]
        box = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                if board[i][j] in rows[i]:
                    return False
                else:
                    rows[i].add(board[i][j])
                if board[i][j] in col[j]:
                    return False
                else:
                    col[j].add(board[i][j])

                box_idx = (i//3)*3 + (j//3)
                if board[i][j] in box[box_idx]:
                    return False
                else:
                    box[box_idx].add(board[i][j])
        return True

                


        