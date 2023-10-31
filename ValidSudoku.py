# used a hashset for columns , rows and squares
# iterated over the board , check for uniqueness in hashmap
# for 3x3 squares used squares[r//3 ,c//3] and added
# time complexity : 0(n^2) [iterating over board n*n] space complexity : 0(n) 

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set)

        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue
                if (board[r][c] in rows[r] or
                    board[r][c] in cols[c] or
                    board[r][c] in squares[(r//3,c//3)]):
                    return False
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r//3,c//3)].add(board[r][c])
            
        return True