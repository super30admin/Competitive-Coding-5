
"""
time complexity: O(n^2) where n is the number of rows/columns in the board
space complexity: O(n^2) in the worst case when all cells are filled with numbers. 
We use three dictionaries to keep track of the numbers seen in each row, column, and 3x3 sub-box. 
We iterate through each cell in the board and check if the current number has already been seen in the corresponding row, column, or sub-box. 
If it has been seen, we return False. If it has not been seen, we add it to the respective dictionaries.
"""
from typing import List
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_dict={}
        col_dict={}
        inner_dict={}
        for i in range(len(board)):
            for j in range(len(board)):
                curr = board[i][j]
                if curr == ".":
                    continue

                if i not in col_dict:
                    col_dict[i] = set()
                    col_dict[i].add(curr)
                else:
                    if curr in col_dict[i]:
                        return False
                    else:
                        col_dict[i].add(curr)
                if j not in row_dict:
                    row_dict[j] = set()
                    row_dict[j].add(curr)
                else:
                    if curr in row_dict[j]:
                        return False
                    else:
                        row_dict[j].add(curr)
                inner_board_coord = (i//3, j//3)
                if inner_board_coord not in inner_dict:
                    inner_dict[inner_board_coord] = set()
                    inner_dict[inner_board_coord].add(curr)
                else:
                    if curr in inner_dict[inner_board_coord]:
                        return False
                    else:
                        inner_dict[inner_board_coord].add(curr)
        
        return True
                 