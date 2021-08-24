"""
Time Complexity : O(n^2)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        rows = [[0]*N for _ in range(N)]
        cols = [[0]*N for _ in range(N)]
        box = [[0]*N for _ in range(N)]
        for r in range(N):
            for c in range(N):
                if board[r][c] == ".": continue
                # Calculate the index as we have to change it as seen on index - 1
                idx = int(board[r][c]) - 1
                # Check if the rows contains any duplicates
                if rows[r][idx] == 1:
                    return False
                rows[r][idx] = 1
                # Check if any columns contain any duplicates
                if cols[c][idx] == 1:
                    return False
                cols[c][idx] = 1
                # Check if an individual box contain any duplicates
                pos_idx = (r//3)*3 + c//3
                if box[idx][pos_idx] == 1:
                    return False
                box[idx][pos_idx] = 1
        return True