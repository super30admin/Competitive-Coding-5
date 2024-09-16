# Time Complexity : O(m*n) where m and n are dimensions of matrix
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I store a set for each row column and box id and I check for each number if it is in it's respective
# set. If yes then I return false else at the end I return true

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        boxId = lambda i, j: (i // 3)*3 + (j // 3)
        row_hashes = [set() for x in range(9)]
        column_hashes = [set() for x in range(9)]
        box_hashes = [set() for x in range(9)]
        
        for i in range(9):
            for j in range(9):
                current = board[i][j]
                if current in row_hashes[i]:
                    return False
                elif current != ".":
                    row_hashes[i].add(current)
                    
                if current in column_hashes[j]:
                    return False
                elif current != ".":
                    column_hashes[j].add(current)
                    
                box_id = boxId(i,j)
                if current in box_hashes[box_id]:
                    return False
                elif current != ".":
                    box_hashes[box_id].add(current)
                    
        return True