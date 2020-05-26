# Time Complexity: O(n^2)
# Space complexity: O(n), using three maps to store values of rows, coloums and the numbers in the box
#ran successfully in Leetcode:Yes

# Algorithm :
# 1. Traverse through the given matrix, 
# 2. Create three maps for rows, cols, and one for storing numbers in a 3x3 matrix .
# 3. Check if the encountered number already exists in the map , if not add it to the map. 
class Solution:
    def isValidSudoku(self, board):
   

        map_row = [{} for _ in range(9)]
        map_col = [{} for _ in range(9)]
        map_cell = [[{} for _ in range(3)] for __ in range(3)]
        for i in range(9):
            for j in range(9):
                char = board[i][j]
                if char == '.': continue
                if char in map_row[i]: return False
                else: map_row[i][char] = [i,j]
                if char in map_col[j]: return False
                else: map_col[j][char] = [i,j]
                if char in map_cell[i//3][j//3]: return False
                else: map_cell[i//3][j//3][char] = [i,j]
        return True
