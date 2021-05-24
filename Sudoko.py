""" Valid Sudoku
Time Complexity: O(1)
Space Complexity: O(1) constant time
Approach - use hashsets"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSet=[set() for i in range(9)]
        colSet=[set() for i in range(9)]
        gridSet=[set() for i in range(9)]
        
        #iterate through the board
        for i in range(len(board)):
            for j in range(len(board[0])):
                if not board[i][j] == ".":
                    curr = board[i][j]
                    
                    #rows
                    if curr in rowSet[i]:
                        return False
                    else:
                        rowSet[i].add(curr)
                    
                    #cols
                    if curr in colSet[j]:
                        return False
                    else:
                        colSet[j].add(curr)
                    
                    #grid - need to determine grid here
                    gridindex = i//3 *3 + j//3
                    if curr in gridSet[gridindex]:
                        return False
                    else:
                        gridSet[gridindex].add(curr)
                    
        return True
                