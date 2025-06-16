# // Time Complexity : o(1)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : understanding the boxes computiona


# // Your code here along with comments explaining your approach
# maintain hashset for rows columns and boxes , iterate over the array and check if they already exists 
from typing import List,DefaultDict
import collections
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m,n = len(board), len(board[0])
        rset = collections.defaultdict(set)
        cset = collections.defaultdict(set)
        bset = collections.defaultdict(set)

        for i in range(m):
            for j in range(n):
                if board[i][j] == '.':
                    continue
                val = board[i][j]
                if val in rset[i] or val in cset[j] or val in bset[(i//3,j//3)]:
                    return False

                rset[i].add(val)
                cset[j].add(val)
                bset[(i//3,j//3)].add(val)          

        return True
                    
                
        