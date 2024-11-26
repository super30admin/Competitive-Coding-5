# Time and space complexity = O(n^2)
from collections import defaultdict


class Solution:
       def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = defaultdict(set) # It will create a dict with key as indexes from 0-9 and add the values as a set for respective index
        rows = defaultdict(set) # Same for Queue (key:set()) eg. {0: {'7', '3', '5'}})
        squares = defaultdict(set) # Same dictionary for the squares

        for r in range(9):      # Iterating over every element in the board
            for c in range(9):
                if board[r][c] == '.':  # If the value is . continue
                    continue
                if (board[r][c] in rows[r] or # We'll check if the current value exist in the respective row 
                    board[r][c] in cols[c] or # We'll check if the current value exist in the respective Col 
                    board[r][c] in squares[(r//3,c//3)]): # We'll check if the current value exist in the respective matrix 
                    return False    # If yes, not a valid sudoku
                cols[c].add(board[r][c])    # Adding the values to dictionaries
                rows[r].add(board[r][c])
                squares[(r//3,c//3)].add(board[r][c])
        return True
        