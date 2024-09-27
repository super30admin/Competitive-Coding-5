# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # create set to save what you checked
        myset = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                #check box
                currbox = board[i][j]+str(i//3)+str(j//3)
                #check row
                curr_r = board[i][j] +'r'+str(i)
                #check sol
                curr_c = board[i][j] +'c'+str(j)
                #if cound before return true else add to set
                if (board[i][j] != ".") and (currbox in myset or curr_r in myset or curr_c in myset):
                    return False
                myset.add(currbox)
                myset.add(curr_r)
                myset.add(curr_c)
        return True