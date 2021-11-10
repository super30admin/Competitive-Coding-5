#Time complexity O(n), space O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if self.valid(board,i,j)==False:
                    return False
                
        return True
  
#For checking row,column and sub box
    def valid(self,board,i,j):
        
        if board[i][j]==".":
            return True
     #For row   
        for n in range(len(board)):
            if n!=i and board[n][j]==board[i][j]:
                return False
    #For column
        for m in range(len(board[0])):
            if m!=j and board[i][m]==board[i][j]:
                return False
    #For sub box
        for n in range(i//3*3,i//3*3+3):
            for m in range(j//3*3,j//3*3+3):
                if (n!=i or m!=j) and board[n][m]==board[i][j]:
                    return False
                
        return True
                
