# Time Complexity:- O(1) //given that the board will always be 9x9 which gives a constant time and space solution
# Space Complexity:- O(1)
# Approach:- Do as the problem says validate the row first using a set and then the column and then the submatrices.
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def validaterow(board,i):
            hashset=set()
            for j in range(len(board[0])):
                if board[i][j]==".":
                    continue
                if board[i][j] in hashset:
                    return True
                else:
                    hashset.add(board[i][j])
        def validatecolumn(board,j):
            hashset=set()
            for i in range(len(board)):
                if board[i][j]==".":
                    continue
                if board[i][j] in hashset:
                    return True
                else:
                    hashset.add(board[i][j])
        submatrice=[]
        for i in range(9):
            submatrice.append(set())
        for i in range(len(board)):
            if validaterow(board,i):
                return False
        for j in range(len(board[0])):
            if validatecolumn(board,j):
                return False
        #validate the submatrice
        hashset=set()
        for i in range(0,9):
            for j in range(0,9):
                if board[i][j]==".":
                    continue
                result= "The value at"+ str(i//3) + str(j//3) + "is" + str(board[i][j])
                if result in hashset:
                    return False
                else:
                    hashset.add(result)
        return True
                
                
        
            