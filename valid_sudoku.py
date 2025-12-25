# https://leetcode.com/problems/valid-sudoku/description/

class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        m = len(board)
        n = len(board[0])
        # create a rowset to identify the duplicate
        rowSet = [set() for _ in range(9)]
        # create a colset to identify the duplicate
        colSet = [set() for _ in range(9)]
        # create a boxset to identify the duplicate
        boxSet = [set() for _ in range(9)]

        # iterate over the rows
        for i in range(m):
            # iterate over the columns
            for j in range(n):
                # check if the row has a number
                if board[i][j] != '.':
                    # check if the number is present in set
                    if board[i][j] not in rowSet[i]:
                        # add into the set
                        rowSet[i].add(board[i][j])
                    else:
                        # if it's already present then it's not valid sudoku
                        return False

                if board[j][i] != '.':
                    # check if the number is present in set
                    if board[j][i] not in colSet[i]:
                        # add into the set
                        colSet[i].add(board[j][i])
                    else:
                        # if it's already present then it's not valid sudoku
                        return False

                # create the 3 * 3 boxes using row and column
                boxIdx = (i // 3 + j // 3 * 3) 
                if board[i][j] != '.':
                    if board[i][j] not in boxSet[boxIdx]:
                        boxSet[boxIdx].add(board[i][j])
                    else:
                        return False

        return True


