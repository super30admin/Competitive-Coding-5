#Time complexity: O(1) since the board size is fixed
#Space complexity: O(1)  since the board size is fixed
#Works on leetcode: yes
#Approach: Here we just need to check if all the rows, columns and 3x3 section is valid or not. For a section to be valid
#all the digits in that section need to be unique
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #-kprint(zip(*board))
        return (self.isrowvalid(board) and self.iscolvalid(board) and self.issquarevalid(board))
    
    def validunit(self,val):
        unit = [v for v in val if v!='.']
        #print("FSFD",unit)
        return len(set(unit))==len(unit)
    
    def isrowvalid(self,board):
        for row in board:
            if not self.validunit(row):
                return False
        return True
    
    def iscolvalid(self,board): 
        for col in zip(*board):
            #print("COL",col)
            if not self.validunit(list(col)):
                return False
        return True
    
    def issquarevalid(self,board):
        for i in (0,3,6):
            for j in (0,3,6):
                sq = [board[x][y] for x in range(i,i+3) for y in range(j,j+3)]
                if not self.validunit(sq):
                    return False
        return True