# Time - O(n2)
# Space - O(n2)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        
        def box_number(i, j):
            if i>=0 and i<3:
                if j>=0 and j<3:
                    return 0
                if j>=3 and j<6:
                    return 1
                if j>=6 and j<9:
                    return 2
                
            elif i>=3 and i<6:
                if j>=0 and j<3:
                    return 3
                if j>=3 and j<6:
                    return 4
                if j>=6 and j<9:
                    return 5
            
            else:
                if j>=0 and j<3:
                    return 6
                if j>=3 and j<6:
                    return 7
                if j>=6 and j<9:
                    return 8
                
        digit_count = {}
        
        for i in range(1, 10):
            digit_count[str(i)] = 0
        
        col_tracker = {}
        row_tracker = {}
        box_tracker = {}
        
        for i in range(9):
            
            col_tracker[i] = {"1": 0, "2": 0, "3":0, "4":0, "5":0,"6":0,"7":0,"8":0,"9":0}
            row_tracker[i] = {"1": 0, "2": 0, "3":0, "4":0, "5":0,"6":0,"7":0,"8":0,"9":0}
            box_tracker[i] = {"1": 0, "2": 0, "3":0, "4":0, "5":0,"6":0,"7":0,"8":0,"9":0}
        
        for i in range(9):
            for j in range(9):
                
                if board[i][j] != '.':
                    
                    box = box_number(i, j)
                    
                    col_tracker[j][board[i][j]] += 1
                    row_tracker[i][board[i][j]] += 1
                    box_tracker[box][board[i][j]] += 1
                    if col_tracker[j][board[i][j]] > 1 or row_tracker[i][board[i][j]] > 1 or box_tracker[box][board[i][j]] > 1:
                        
                        return False
        
        return True