#https://leetcode.com/problems/valid-sudoku/description/
# Time Complexity: O(1), the board is always a fixed 9x9 = 81 cells, so the total work never changes regardless of input
# Space Complexity: O(1), the set holds at most 3 entries per cell x 81 cells = 243 string entries, a fixed constant
# Approach: use a single set to track every digit we have seen so far, for each filled cell we build three string keys, one for its row, one for its column and one for its box, if any of these keys already exist in the set, it means we have seen this digit before in that same row, column or box, so the board is invalid

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # one single set to track all three rules at once
        # instead of storing just the digit, we store a descriptive string that encodes both the digit and where it was seen, so one set can handle rows, columns and boxes together
        finalset = set()

        # loop through every cell on the board, i is the row index (0 to 8), j is the column index (0 to 8)
        for i in range(9):
            for j in range(9):

                # skip empty cells, we only validate filled cells
                if board[i][j] != ".":

                    # build three string keys for this cell, each key uniquely describes
                    # "this digit was seen in this specific row / column / box"
                    # check all three keys before adding anything
                    # if any key is already in finalset, this digit appeared before in that same row, column or box
                    # that is a duplicate, so the board is invalid, return False immediately
                    if (board[i][j] + "seen at row" + str(i)) in finalset or \
                    (board[i][j] + "seen at column" + str(j)) in finalset or \
                    (board[i][j] + "seen at box" + str(i//3) + "-" + str(j//3)) in finalset:
                        return False

                    # no duplicate found for this cell, so now we record this digit's presence by adding all three keys into the set so future cells can detect a conflict with this one

                    # records that this digit has been seen in row i
                    finalset.add(board[i][j] + "seen at row" + str(i))

                    # records that this digit has been seen in column j
                    finalset.add(board[i][j] + "seen at column" + str(j))

                    # i//3 gives the box row (0, 1, or 2) and j//3 gives the box column (0, 1, or 2)
                    # together they uniquely identify which of the 9 boxes this cell belongs to
                    finalset.add(board[i][j] + "seen at box" + str(i//3) + "-" + str(j//3))

        # if we made it through all 81 cells without finding any duplicate in any row, column, or box
        # all three sudoku rules are satisfied, so the board is valid
        return True

            