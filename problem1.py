# problem 1 
# check a valid sudoku 

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_arr = [set() for _ in range(9)]
        col_arr = [set() for _ in range(9)]
        box_arr = [set() for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    row_idx = i 
                    col_idx = j
                    box_idx = i//3 + j//3 *3
                    if  board[i][j] in row_arr[row_idx] or board[i][j] in col_arr[col_idx] or board[i][j] in box_arr[box_idx]:
                        return False 
                    row_arr[row_idx].add(board[i][j])
                    col_arr[col_idx].add(board[i][j])
                    box_arr[box_idx].add(board[i][j]) 
        return True 