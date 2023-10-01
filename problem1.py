# https://leetcode.com/problems/valid-sudoku/description/
# Time Complexity: O(1)
# Space Complexity: O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            row_set = set()
            col_set = set()
            box_set = set()
            for j in range(9):
                if board[i][j].isdigit():
                    if board[i][j] in row_set:
                        return False
                    else:
                        row_set.add(board[i][j])
                
                if board[j][i].isdigit():
                    if board[j][i] in col_set:
                        return False
                    else:
                        col_set.add(board[j][i])
                
                # Calculate the 3x3 sub-box indices
                sub_box_row = 3 * (i // 3)
                sub_box_col = 3 * (i % 3)
                element = board[sub_box_row + j // 3][sub_box_col + j % 3]
                if element.isdigit():
                    if element in box_set:
                        return False
                    else:
                        box_set.add(element)

        return True
