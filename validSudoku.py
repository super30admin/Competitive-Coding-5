#Time Complexity: O(n^2)
#Space Complexity: O(n)
#Did it run on Leetcode: Yes

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = len(board)
        columns = len(board[0])
        for row in board:
            row_check = set()
            for element in row:
                if element == ".":
                    continue
                if element in row_check:
                    return False
                row_check.add(element)
        for index in range(columns):
            col_check = set()
            for jindex in range(rows):
                print(jindex, ":", index)
                if board[jindex][index] == ".":
                    continue
                if board[jindex][index] in col_check:
                    return False
                col_check.add(board[jindex][index])
        for index in range(0, rows, 3):
            for jindex in range(0, columns, 3):
                blocks_check = set()
                for x in range(index,index+3):
                    for y in range(jindex, jindex+3):
                        if board[x][y] == ".":
                            continue
                        if board[x][y] in blocks_check:
                            return False
                        blocks_check.add(board[x][y])
        return True