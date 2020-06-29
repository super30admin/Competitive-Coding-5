//Time Complexity: O(1) as the size of the matrix is always same - 
//Time Complexity: O(1) as the size of the matrix is always same
class Solution(object):
    def isValidSudoku(self, board):
        
        hashSet = set()
            
        for i in range(9):
            for j in range(9):
                if(board[i][j] != "."):
                    if (str(board[i][j]) + "found in row" + str(i) in hashSet):
                        return False
                    else:
                        hashSet.add(str(board[i][j]) + "found in row" + str(i))

                    if (str(board[i][j]) + "found in column" + str(j) in hashSet):
                        return False
                    else:
                        hashSet.add(str(board[i][j]) + "found in column" + str(j))

                    if (str(board[i][j])+ "found in box" +str(i/3)+"-"+str(j/3)  in hashSet):
                        return False
                    else:
                        hashSet.add(str(board[i][j])+ "found in box" +str(i/3)+"-"+str(j/3))
        return True
