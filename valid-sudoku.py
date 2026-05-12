# Time Complexity: O(n^2)
# Space Complexity: O(n^2)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        n=len(board)
        rh=[set() for i in range(9)]
        ch=[set() for i in range(9)]
        bh=[set() for i in range(9)]

        for r in range(9):
            for c in range(9):
                e=board[r][c]

                if e=='.': continue 

                if e in rh[r]: return False
                rh[r].add(e)

                if e in ch[c]: return False
                ch[c].add(e)

                bi = (r//3)+(c//3)*3
                if e in bh[bi]: return False
                bh[bi].add(e)
        
        return True