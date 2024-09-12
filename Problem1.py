"""

    Name : Shahreen Shahjahan Psyche
    Time : O(1) [As, I am traversing the Suduku board 3*9*9 times]
    Space : O(1)

    This code ran successfully for all the test cases in Leetcode.

"""

from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        row = len(board)
        col = len(board[0])
        
        # Space : O(1)
        records = {"1" : 0,
                   "2" : 0,
                   "3" : 0,
                   "4" : 0,
                   "5" : 0,
                   "6" : 0,
                   "7" : 0,
                   "8" : 0,
                   "9" : 0
                   }
        
        # i -> row
        # j -> col
        
        # Time : O(M*N) [9 * 9]
        # checking for each column
        for j in range(col):
            for key in records.keys():
                records[key] = 0
            for i in range(row): 
                if board[i][j] == ".":
                    continue
                if records[board[i][j]] > 0:
                    return False
                else:
                    if board[i][j] != ".":
                        records[board[i][j]] = 1
            
        
        # resetting hashmap
        for key in records.keys():
                records[key] = 0  
                
        # Time : O(M*N) [9 * 9]
        # checking for each row
        for i in range(col):
            for key in records.keys():
                records[key] = 0
            for j in range(row): 
                if board[i][j] == ".":
                    continue
                if records[board[i][j]] > 0:
                    return False
                else:
                    if board[i][j] != ".":
                        records[board[i][j]] = 1
            
            
        
        # resetting hashmap  
        for key in records.keys():
            records[key] = 0
        
        # Time : O(M*N) [9 * 9]
        # checking block - wise
        
        block_size = row // 3
        
        i , j = 0, 0
        count_i = 0
        count_j = 0
        count = 0
        
        while(count_j < 3):
            # direction of my block checking is upwards to downwards. After that shift to 3 blocks right
            count_i = 0
            while(count_i < 3):
                pos_i = i + block_size #  0 + 3 = 3
                pos_j = j + block_size # 3  + 3 = 6
                
                k = i
                l = j
                
                while(k < pos_i):
                    l = j
                    while(l < pos_j):
                        if board[k][l] == ".":
                            l += 1
                            continue
                        elif records[board[k][l]] > 0:
                            return False
                        else:
                            if board[k][l] != ".":
                                records[board[k][l]] = 1
                        l += 1
                    k += 1
                
                for key in records.keys():
                    records[key] = 0
                
                i = i + block_size
                count_i += 1
                
                
            
            i = 0
            j = j + block_size
            count_j += 1
                
        return True  
            
            
            
            
                
                