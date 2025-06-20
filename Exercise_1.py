# S30 Problem #68 Valid Sudoku
#LeetCode #36 https://leetcode.com/problems/valid-sudoku/

# Author : Akaash Trivedi
# Time Complexity : O(1) two for loops but with constant space O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m = 9
        rows = [set() for _ in range(m)]
        cols = [set() for _ in range(m)]
        boxes = [set() for _ in range(m)]

        for r in range(m):
            for c in range(m):
                if board[r][c] == ".":
                    continue
                
                if board[r][c] in rows[r]:
                    return False
                rows[r].add(board[r][c])

                if board[r][c] in cols[c]:
                    return False
                cols[c].add(board[r][c])

                # get the index for box
                # multiple the row by 3 ad adding column to get unique
                # [0][1][2]
                # [3][4][5]
                # [6][7][8]
                idx = (r // 3)*3 + c//3
                if board[r][c] in boxes[idx]:
                    return False
                boxes[idx].add(board[r][c])
        return True