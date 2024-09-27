# // Time Complexity : O(n^2)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No




import collections
class Solution:
    def isValidSudoku(self, board):
        
        # to store the unique values 
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        squares = collections.defaultdict(set)
        
        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue
                if (
                    board[r][c] in rows[r] or  # if duplicates in row
                    board[r][c] in cols[c] or  # if duplicates in cols
                    board[r][c] in squares[(r//3),(c//3)] # if duplicates in boxes
                    ):
                    return False
                
                # add the values to the dict, so it can detect any duplicates in next iteration
                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                squares[(r//3),(c//3)].add(board[r][c])
                
        return True
        