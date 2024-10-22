'''
    Time Complexity: O(1)
    Space Complexity: O(1)
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        checkSet = set()
        # row
        for i in range(9):
            checkSet.clear()
            for j in range(9):
                if board[i][j] in checkSet:
                    return False
                if board[i][j] != ".":
                    checkSet.add(board[i][j])
        
        # column
        for j in range(9):
            checkSet.clear()
            for i in range(9):
                if board[i][j] in checkSet:
                    return False
                if board[i][j] != ".":
                    checkSet.add(board[i][j])

        # block
        for k in range(9):
            quo = k//3
            rem = k%3

            checkSet.clear()
            for i in range(quo*3, quo*3+3):
                for j in range(rem*3, rem*3+3):
                    if board[i][j] in checkSet:
                        return False
                    if board[i][j] != ".":
                        checkSet.add(board[i][j])

        return True
