# // Time Complexity :O(m*n)
# // Space Complexity :O(m)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None or len(board) is not 9 or len(board[0]) is not 9:
            return False
        #row

        for i in range(9):
            b=[False for i in range(9)]
            for j in range(9):
                if board[i][j] is not '.':
                
                    if(b[int(ord(board[i][j])-ord('1'))]):
                        return False
                    b[int(ord(board[i][j])-ord('1'))]=True
        for j in range(9):
            b=[False for i in range(9)]
            for i in range(9):
                if board[i][j] is not '.':
                    if b[int(ord(board[i][j])-ord('1'))]:
                        return False
                    b[int(ord(board[i][j])-ord('1'))]=True
        for block in range(9):
            b=[False for i in range(9)]
            for i in range((block//3)*3,((block//3)*3)+3):
            
                for j in range((block%3)*3,((block%3)*3)+3):
                
                    print("a",i,j,board[i][j])
                    
                    if board[i][j] is not '.':
                        if b[int(ord(board[i][j])-ord('1'))]:
                            return False
                        b[int(ord(board[i][j])-ord('1'))]=True
        return True

            
            
            
        