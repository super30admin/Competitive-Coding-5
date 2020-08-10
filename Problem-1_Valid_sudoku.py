# APPROACH 1: BRUTE FORCE - MULTI-PASS 
# Time Complexity : O(1), asymptotically  O(3* n^2), n: number of rows( or columns) of the board
# Space Complexity : O(1), asymptotically  O(27 * n), n: number of rows( or columns) of the board
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Check for each row, if digits get repeated using a list where 0 - absence and 1 - presence using ind. Use ord() as input is in char. Ignore if the char is '.'
# 2. If same digit is found in any row, immediately return False.
# 3. Similarly for each column also.
# 4. For sub-grid check, maintain rstarting row, column and ending row, column. Do the same above check here
# 5. When u reach column end - update starting column -> ending column and inc ending column by 3
# 6. When current column is the last column (or process 3rd or 6th subgrid), update starting row-> ending row and update starting col and ending col to 0 ad 3 resp. 

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        if board is None:
            return True
    
        for row in range(len(board)):
            curr_list = [0 for _ in range(9)]
            for col in range(len(board[0])):
                if board[row][col] != '.':
                    
                    if curr_list[ord(board[row][col]) - ord('0') - 1] == 1:
                        return False
                    else:
                        curr_list[ord(board[row][col]) - ord('0') - 1] = 1
                    
                    
        for col in range(len(board[0])):
            curr_list = [0 for _ in range(9)]
            for row in range(len(board)):
                if board[row][col] != '.':
                    if curr_list[ord(board[row][col]) - ord('0') - 1] == 1:
                        return False
                    else:
                        curr_list[ord(board[row][col]) - ord('0') - 1] = 1
                    
        
        row_start, row_end, col_start, col_end, sub_count = 0, 3, 0, 3, 0
        
        while sub_count < 9:
            curr_list = [0 for _ in range(9)]
            for row in range(row_start, row_end):
                for col in range(col_start, col_end):
                    if board[row][col] != '.':
                        if curr_list[ord(board[row][col]) - ord('0') - 1] == 1:
                            return False
                        else:
                            curr_list[ord(board[row][col]) - ord('0') - 1] = 1
             
            sub_count += 1
            if sub_count % 3 == 0:
                row_start = row_end
                row_end += 3
                col_start, col_end = 0, 3
            
            else:
                col_start = col_end
                col_end += 3
                
                
        return True
                    
        
        

# APPROACH  2: OPTIMAL APPROACH - ONE PASS
# Time Complexity : O(1), asymptotically  O(n^2), n: number of rows( or columns) of the board
# Space Complexity : O(1), asymptotically  O(13 * n), n: number of rows( or columns) of the board (refer point 2 below)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Visit each element exactly once, row-wise manner
# 2. So at a time 1 list for each row, 9 lists for each of the 9 columns and 3 list for each sub-grid
# 3. As you process a row, check all the elements in the row list, check and mark visited for the elements in each of the column list, and the same for sub-groups of 3 in each
#    sub-grid list
# 4. When you reach 3rd or 6 th row, reinitialise the sub-grid lists to process the next 3 sub-grids

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        if board is None:
            return True
        
       
        col_list = [[0 for _ in range(9)] for _ in range(9)]
        
        for row in range(len(board)):
            row_list = [0 for _ in range(9)]
            
            if row % 3 == 0:
                sub_list = [[0 for _ in range(9)] for _ in range(3)]
                
            for col in range(len(board[0])):
                
                if board[row][col] != '.':
                    
                    if row_list[ord(board[row][col]) - ord('0') - 1] == 1:
                        return False
                    else:
                        row_list[ord(board[row][col]) - ord('0') - 1] = 1
                        
                    if col_list[col][ord(board[row][col]) - ord('0') - 1] == 1:
                        return False
                    else:
                        col_list[col][ord(board[row][col]) - ord('0') - 1] = 1
                        
                    if col >= 0 and col < 3:
                        col_num = 0
                    elif col >= 3 and col < 6:
                        col_num = 1
                    else:
                        col_num = 2
                        
                    if sub_list[col_num][ord(board[row][col]) - ord('0') - 1] == 1:
                        return False
                    else:
                        sub_list[col_num][ord(board[row][col]) - ord('0') - 1] = 1
                        
                        
        return True
        
