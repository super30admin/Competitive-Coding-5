#valid sudoku

# // Time Complexity : O(N^2)
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def isValidSudoku(self, board):
    valid=set()
    for i in range(len(board)):
        for j in range(len(board)):
            if(board[i][j] !="."):
                if((board[i][j],i) in valid):                   #if the combination of the (number, row number) is already in the set, then return false
                    return False
                else:                                              #if not add it to the set
                    valid.add((board[i][j],i))
                    
                if((j, board[i][j]) in valid):
                    return False
                else:
                    valid.add((j, board[i][j]))
                
                if((board[i][j],i//3,j//3) in valid):
                    return False
                else:
                    valid.add((board[i][j],i//3,j//3))
                        
    return True