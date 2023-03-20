""" 
Time Complexity : O(M * N) M= no.of rows; N=no. of cols
Space Complexity :O(M * N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem: https://leetcode.com/problems/valid-sudoku/description/
Your code here along with comments explaining your approach
"""


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = len(board)
        c = len(board[0])
        row_set = collections.defaultdict(set)
        col_set = collections.defaultdict(set)
        # Key: (r/2, c/2)
        matrix_set = collections.defaultdict(set)
       
        for i in range(r):
            for j in range(c):
                if board[i][j] == '.':
                    continue
                if (board[i][j] in row_set[i] or
                    board[i][j] in col_set[j] or
                    board[i][j] in matrix_set[(i//3, j//3)]):
                    return False

                row_set[i].add(board[i][j])
                col_set[j].add(board[i][j])
                matrix_set[(i//3, j//3)].add(board[i][j])

        return True



        