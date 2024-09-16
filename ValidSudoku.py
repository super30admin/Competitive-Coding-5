#36. Valid Sudoku
"""
Time Complexity : O(n^2) #or O(1) because size is fixed
Space Complexity : O(n^2) #or O(1) because size is fixed
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [set() for _ in range(9)]
        column = [set() for _ in range(9)]
        matrix = {(0, 0): set(), (0, 1): set(), (0, 2): set(), (1, 0): set(), (1, 1): set(), (1, 2): set(),
                   (2, 0): set(), (2, 1): set(), (2, 2): set()}
        print(row)
        print(column)
        
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    
                    if board[i][j] in row[i]:
                         return False
                    else:
                        row[i].add(board[i][j])

                    if board[i][j] in column[j]:
                        return False
                    else:
                        column[j].add(board[i][j])

                    if board[i][j] in matrix[(i // 3, j // 3)]:
                        return False
                    else:
                        matrix[(i // 3, j // 3)].add(board[i][j])
        
        return True
