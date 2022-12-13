#Time complexity: O(1)
#Space complexity: O(1)

#Accepted on Leetcode

#Approach
#Check each row, col and block if there is a repetition (Total 9*9*3 checks )


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #checking each row one by one
        for i in range(0,9):
            check = [-1 for x in range(9)]
            for j in range(0,9):
                if board[i][j] != '.':
                    if check[int(board[i][j])-1] == 1:
                        return False
                    check[int(board[i][j])-1] = 1

        #checking each col
        for i in range(0,9):
            check = [-1 for x in range(9)]
            for j in range(0,9):
                if board[j][i] != '.':
                    if check[int(board[j][i])-1] == 1:
                        return False
                    check[int(board[j][i])-1] = 1


        #checking each block
        for block in range(0,9):
            check = [-1 for x in range(9)]
            for i in range((block//3) * 3, (block//3) * 3 + 3):
                for j in range((block % 3) * 3, (block % 3) * 3 + 3):
                    if board[i][j] != '.':
                        if check[int(board[i][j])-1] == 1:
                            return False
                        check[int(board[i][j])-1] = 1


        return True

