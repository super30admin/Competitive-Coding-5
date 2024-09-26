# TC & SC: O(1) fixed input
# Ill maintain 3 array of sets: row sets, col sets and box sets. Each set stores respective row, col or box elements. I keep appending unique values to respective sets while traversing the input sudoku matrix. With O(1) look up I check if element exists in its respective row, col n box sets before appending. If its exists, not a valid sudoku!
class Solution:
    def isValidSudoku(self, board):
        # row sets, col sets n box sets (0-8)
        rows = [set() for i in range(9)]
        columns = [set() for i in range(9)]
        boxes = [set() for i in range(9)]
        
        # traverse input matrix
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    # calculate box index for each position. Formula for computing position of 2D array in 1D array: row number * (number of columns) + column number. Here we will consider each 3 rows as single row to compute box index.
                    boxIdx = i//3 * 3 + j//3
                    # check if it already occurred in the row, col or box
                    if num in rows[i] or num in columns[j] or num in boxes[boxIdx]:
                        return False

                    # append value to all 3 sets
                    rows[i].add(num)
                    columns[j].add(num)
                    boxes[boxIdx].add(num)
        return True