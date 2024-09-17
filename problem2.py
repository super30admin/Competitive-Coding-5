Sudoku Validation:

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board or not board[0] or len(board)!=9 or len(board[0])!=9:
            return False
        
        for i in range(9):
            check=[False for j in range(9)]
            for j in range(9):
                if board[i][j]!='.':
                    if check[int(board[i][j])-1]==True:
                        return False
                    check[int(board[i][j])-1]=True
        
        for j in range(9):
            check=[False for i in range(9)]
            for i in range(9):
                if board[i][j]!='.':
                    if check[int(board[i][j])-1]==True:
                        return False
                    check[int(board[i][j])-1]=True
        
        for block in range(9): 
            check=[False for j in range(9)]
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):
                    if board[i][j]!='.':
                        if check[int(board[i][j])-1]==True:
                            return False
                        check[int(board[i][j])-1]=True
        return True
