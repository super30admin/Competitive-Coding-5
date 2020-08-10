"""
Problem:
https://leetcode.com/problems/valid-sudoku/

Approach: 

1. validte each row : for each row, start putting values in the set, if we encounter a value which is alredy in set, return false
2. validte each column : for each column, start putting values in the set, if we encounter a value which is alredy in set, return false
3. validte each sub-box : for each sub-box, start putting values in the set, if we encounter a value which is alredy in set, return false


"""

# Time Complexity : O(m*n) , m is rows, n is columns, here m=n=9
# Space Complexity :  O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board==None or len(board)==0:
            return False
        
        ## check row
        for i in range(9):
            rowSet =set()
            for j in range(9):
                if board[i][j] in rowSet:
                    return False
                else:
                    if board[i][j] != '.':
                        rowSet.add(board[i][j])
        
        ## check column
        for j in range(9):
            colSet =set()
            for i in range(9):
                if board[i][j] in colSet:
                    return False
                else:
                    if board[i][j] != '.':
                        colSet.add(board[i][j])
                        
        ## check in boxes
        blocks = 9
        for b in range(blocks):
            boxSet =set()
            for i in range(b//3*3, b//3*3+3):
                for j in range (b%3*3, b%3*3+3):
                    if board[i][j] in boxSet:
                        return False
                    else:
                        if board[i][j]!='.':
                            boxSet.add(board[i][j])
        return True        