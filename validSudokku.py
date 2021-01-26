# Approach: We maintain sets for rows, cols and boxes' coordinates that we come across. Any time the value in board is valid we check 
# if we have seen the coords representing this number in the 3 sets earlier, if yes we return False

# Time - O(1)
# Space - O(1)

# Time is constant as we will always be traversing only 81 cells in a sudokku board
# Space -- constant as we will only be storing values out of 81 total values in the board
# Successfully ran on leetcode, no problems faced

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        if not board or len(board) != 9 or len(board[0]) != 9:
            return False

        rows_seen = set()
        cols_seen = set()
        boxes_seen = set()
        for i in range(9)
            for j in range(9):
                val = board[i][j]

                if val == '.':
                    continue
                
                if (i, val) in rows_seen:
                    return False

                if (j, val) in cols_seen:
                    return False

                if (i//3, j//3, val) in boxes_seen:
                    return False
                    
                # if the values are not seen add to last seen set    
                rows_seen.add((i, val))
                cols_seen.add((j, val))
                boxes_seen.add((i//3, j//3, val))
                        
        return True
                    
                    
                
                 