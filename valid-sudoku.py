"""
Runtime Complexity:
O(n^2) - we iterate over n rows and n columns to check the values.
Space Complexity:
O(n) - since we are storing everything as binary and no new data structure like hashmap/hashset was used to eliminate the redundancy. In the worst case
we might endup having 3N binary numbers.
Yes, the code worked.

"""


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        rows = [0]*N
        cols = [0]*N
        box = [0]*N
        
        for r in range(N):
            for c in range(N):
                if board[r][c]==".":
                    continue
                pos = int(board[r][c])-1
                # means the i+1 index have been already visited
                if rows[r] & (1<<pos):
                    return False
                rows[r]|= (1<<pos)
                
                if cols[c] & (1<<pos):
                    return False
                cols[c]|= (1<<pos)
                
                index = (r//3)*3 +c//3
                if box[index] & (1<<pos):
                    return False
                box[index]|= (1<<pos)
                
        return True