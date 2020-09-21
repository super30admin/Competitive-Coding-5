# Time Complexity : O(1)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Use sets for handling duplciates values
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        set_row = set()
        set_col = set()
        set_box = set()
        
        for i in range(0,9):
            for j in range(0,9):
                if board[i][j] != '.':
                    y = i // 3
                    x = j // 3
                 
                    num = board[i][j]
                    
                    if (i, num) in set_row or (num,j) in set_col or (y,x,num) in set_box:
                        return False
                    else:
                        set_row.add((i, num))
                        set_col.add((num, j))
                        set_box.add((y,x,num))
        
        return True
