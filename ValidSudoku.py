# Iterate through Each row, each column and each box to see if there are any duplicates between 1-9 in them
# Time Complexity is O(1) since board size is always 9x9 and O(nxn) = O(81) = O(1)
# Space Complexity is O(1), since we are using a hashset of constant size 9
class Solution(object):
    def checkBox(self,board,i,j):
        mem = set()
        for p in range(i,i+3):
            for q in range(j,j+3):
                val = board[p][q]
                if(val == "."):
                    continue
                if(val in mem):
                    return False
                mem.add(val)
        return True
    
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # Check if rows are unique
        for i in range(9):
            mem = set()
            for j in range(9):
                val = board[i][j]
                if(val == "."):
                    continue
                if(val in mem):
                    return False
                mem.add(board[i][j])
                
        # Check if columns are unique
        for j in range(9):
            mem = set()
            for i in range(9):
                val = board[i][j]
                if(val == "."):
                    continue
                if(val in mem):
                    return False
                mem.add(board[i][j])
        
        # Check the boxes
        for i in range(0,9,3):
            for j in range(0,9,3):
                check = self.checkBox(board,i,j)
                if(not check):
                    return False
        
        return True