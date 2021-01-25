#Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        if(board==None):
            return False
        
        #row
        for i in range(9):
            boolarr=[False]*9
            for j in range(9):
                if(board[i][j]!='.'):
                    ind=int(board[i][j])
                    ind-=1
                    if(boolarr[ind]):
                        return False
                    else:
                        boolarr[ind]=True
        
        #Column
        for i in range(9):
            boolarr=[False]*9
            for j in range(9):
                if(board[j][i]!='.'):
                    ind=int(board[j][i])
                    ind-=1
                    if(boolarr[ind]):
                        
                        return False
                    else:
                        boolarr[ind]=True
                        
        #Small GRid
        strarr=[[0,0],[0,3],[0,6],[3,0],[3,3],[3,6],[6,0],[6,3],[6,6]]
        for k in strarr:
            r=k[0]
            c=k[1]
            boolarr=[False]*9
            for i in range(r,r+3):
                for j in range(c,c+3):
                    if(board[i][j]!='.'):
                        ind=int(board[i][j])
                        ind-=1
                        if(boolarr[ind]):
                            return False
                        else:
                            boolarr[ind]=True
        return True
            
            
        
        
                