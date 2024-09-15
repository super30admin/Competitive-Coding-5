"""
https://leetcode.com/problems/valid-sudoku/
Apprach: going to take an array of n size and then if we encounter an element lets say 5 in a row
we can put index 4 =True in the array, if we go further in the row and find the same elemnt, the same
index in the array will be true so we could return false. Repeat this process for for every row,
every column and every block
"""
"""
https://leetcode.com/problems/valid-sudoku/
Apprach: going to take an array of n size and then if we encounter an element lets say 5 in a row
we can put index 4 =True in the array, if we go further in the row and find the same elemnt, the same
index in the array will be true so we could return false. Repeat this process for for every row,
every column and every block
"""


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board[0]) != 9 or len(board) != 9:
            return False

            ##for checking row
        for i in range(9):
            boolean = [False] * 9
            for j in range(9):
                ##if its integer
                if board[i][j] != ".":
                    ##if number then check if arrray for corresponding is marked true
                    if boolean[int(board[i][j]) - 1] == True:

                        return False
                    else:
                        boolean[int(board[i][j]) - 1] = True

        ###for checking column (swap j and i in for lop)
        for j in range(9):
            boolean = [False] * 9
            for i in range(9):
                ##if its integer
                if board[i][j] != '.':
                    ##if number then check if arrray for corresponding is marked true
                    if boolean[int(board[i][j]) - 1] == True:

                        return False
                    else:
                        boolean[int(board[i][j]) - 1] = True

        ###for block
        for block in range(9):
            boolean = [False] * 9
            for i in range((block // 3) * 3, (block // 3) * 3 + 3):
                ##if its integer
                for j in range((block % 3) * 3, (block % 3) * 3 + 3):
                    if board[i][j] != '.':
                        ##if number then check if arrray for corresponding is marked true
                        if boolean[int(board[i][j]) - 1] == True:
                            print("hgitting here")
                            return False
                        else:
                            boolean[int(board[i][j]) - 1] = True

        return True





