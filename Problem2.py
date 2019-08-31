class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # checking every row
        for i in board:
            # filter will remove the "."'s from the row for comparison
            if len(list(filter(lambda a: a != ".", i))) != len(set(filter(lambda a: a != ".", i))): # set will remove the repetitions in the list
                return False
        # checking every column
        for i in zip(*board):
            if len(list(filter(lambda a: a != ".", i))) != len(set(filter(lambda a: a != ".", i))): # set will remove the repetitions in the list
                return False
        # checking every 3x3 matrix
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3) if board[x][y] != "."]
                if(len(square) != len(set(square))): # set will remove the repetitions in the list
                    return False
        return True