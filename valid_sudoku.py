class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #O(m*n)
        #O(n)
        m=len(board)
        n=len(board[0])
        #make sets for 3 checking points
        row,col,block=set(),set(),set()
        for i in range(m):
            for j in range(n):
                #if number is present
                if board[i][j]!=".":
                    #tuple of index, value
                    r=(i,board[i][j])
                    c=(j,board[i][j])
                    b=(i//3,j//3,board[i][j])#block index will be 0 for 1st 3*3 block
                    
                    #if this tuple is already present in set>>invalid
                    if r in row or c in col or b in block:
                        return False
                    
                    #add new tuples in sets
                    row.add(r)
                    col.add(c)
                    block.add(b)
        return True
                    