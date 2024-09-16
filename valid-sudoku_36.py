#Approach: Maintaining Hashset of default dict for every row, colum and squares
#Time Complexity O(N*N) N=9 so O(N^2)
#Space Complexity O(N^2)
#It successfully runs on leetcode   
from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_nums = defaultdict(set)
        col_nums = defaultdict(set)
        sub_box_nums = defaultdict(set)
        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    continue
                if (board[r][c] in row_nums[r] or board[r][c] in col_nums[c] 
                    or board[r][c] in sub_box_nums[(r // 3, c // 3)]):
                    return False
                row_nums[r].add(board[r][c])
                col_nums[c].add(board[r][c])
                sub_box_nums[(r // 3, c // 3)].add(board[r][c])
        return True


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def notInRow(board, row):
            st = set()
            for i in range(0, 9):
                if board[row][i] in st:
                    return False
                if board[row][i] != '.':
                    st.add(board[row][i])
            return True
        
        def notInCol(board, col):
            st = set()
            for i in range(0, 9):
                if board[i][col] in st:
                    return False
                if board[i][col] != '.':
                    st.add(board[i][col])

            return True
 
        def notInBox(board, startRow, startCol):
            st = set()
            for row in range(0, 3):
                for col in range(0, 3):
                    curr = board[row + startRow][col + startCol]
                    if curr in st:
                        return False
                    if curr != '.':
                        st.add(curr)
            return True
 

        def isValid(board, row, col):
            return (notInRow(board, row) and notInCol(board, col) and
                notInBox(board, row - row % 3, col - col % 3))
            
       
        for i in range(0, 9):
            for j in range(0, 9):
                if not isValid(board, i, j):
                    return False
        return True