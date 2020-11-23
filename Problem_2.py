"""
Time Complexity : O(1)
Space Complexity : O(1)- almost constant as ditcionary can have values only 1-9 and list will be too short 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Whie iterating through the board, we check if we already have that value in a dictionary or not.
If we have, we check for the indices. If we find that it is the same row, or same column or same box,
we return False, otherwise we add the indices to the dictionary 
"""


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        d = {}
        r = len(board)
        c = len(board[0])
        for i in range(r):
            for j in range(c):
                temp = board[i][j]
                if temp in d:
                    for k in d[temp]:
                        if k[0] == i or k[1] == j or (k[0]//3 == i//3 and k[1]//3 == j//3):
                            return False
                    d[temp].append((i, j))
                elif temp != ".":
                    d[temp] = [(i, j)]
        return True
