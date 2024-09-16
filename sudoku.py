"""Approach: Brute Force looping using fixed len arrays
TC O(N^2)
SC O(N^2)
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # brute force
        
        for r in range(len(board)):
            row = [0] * 9
            for c in range(len(board[0])):
                if board[r][c] != ".":
                    pos = int(board[r][c]) -1
                    if row[pos] == 1:
                        return False
                    row[pos] = 1
        
        for c in range(len(board[0])):
            col = [0] * 9
            for r in range(len(board)):
                if board[r][c] != ".":
                    pos = int(board[r][c]) -1
                    if col[pos] == 1:
                        return False
                    col[pos] = 1
        
        for block in range(9):
            blk = [0] * 9
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):
                    if board[i][j] != ".":
                        pos = int(board[i][j]) -1
                        if blk[pos] == 1:
                            return False
                        blk[pos] = 1
        return True

"""Approach 2: Use bitmasking

TC O(N^2) as we need to traverse every position in the board
SC O(N) because  in the worst-case scenario, if the board is full, we need 3N binary numbers to store all seen numbers in all rows, columns, and blocks. 
Note : Code mostly taken from LC solution section. Spent time understanding Bit Masking.
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        # Use binary number to check previous occurrence
        rows = [0] * N
        cols = [0] * N
        blocks = [0] * N

        for r in range(N):
            
            for c in range(N):
                # Check if the position is filled with number
                if board[r][c] == ".":
                    continue

                pos = int(board[r][c]) - 1

                # Check the row
                if rows[r] & (1 << pos):
                    return False
                rows[r] |= (1 << pos)

                # Check the column
                if cols[c] & (1 << pos):
                    return False
                cols[c] |= (1 << pos)

                # Check the box
                idx = (r // 3) * 3 + c // 3
                if blocks[idx] & (1 << pos):
                    return False
                blocks[idx] |= (1 << pos)

        return True