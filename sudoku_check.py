#Time Complexity: O(N**2).
#Auxiliary Space: O(N**2)
#Did this code successfully run on Leetcode :Yes
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        N =9 
        rows = [set() for _ in range(N)]
        cols = [set() for _ in range(N)]
        boxes = [set() for _ in range(N)]
        
        for r in range(N):
            for c in range(N):
                val = board[r][c]
                if val =='.':
                    continue
                
                if val in rows[r]:
                    return False
                rows[r].add(val)
                
                if val in cols[c]:
                    return False
                cols[c].add(val)
                
                bid = (r//3)*3+c//3
                if val in boxes[bid]:
                    return False
                boxes[bid].add(val)
        return True