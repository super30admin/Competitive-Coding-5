#Time Complexity : O(N*N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        row = [set() for _ in range(9)]
        col = [set() for _ in range(9)]
        box = [set() for _ in range(9)]
        
        for i in range(0,9):
            for j in range(0,9):
                val = board[i][j]
                if val == '.':
                    continue
                    
                if val in row[i]:
                    return False
                row[i].add(val)
                if val in col[j]:
                    return False
                col[j].add(val)
                
                index = (i//3) * 3 + j//3
                
                if val in box[index]:
                    return False
                box[index].add(val)
                
        return True
                
                