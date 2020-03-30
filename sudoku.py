'''
Time Complexity: O(1) -> as 9*9 matrix is constant space
Space Complexity: O(1) -> Same reason as before
Did this code successfully run on Leetcode : Yes
Explanation: Iterate through the sudoku for every row, column and block, create a boolean value which is set to true
if we have seen an element at a position, if we see that the element in the boolean array is True we return False
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(0, 9):
            Bool = [False] * 9
            for j in range(0, 9):
                if board[i][j] != '.':
                    element = ord(board[i][j]) - ord('1')
                    if Bool[element] == True:
                        return False

                    Bool[element] = True

        for j in range(0, 9):
            Bool = [False] * 9
            for i in range(0, 9):
                if board[i][j] != '.':
                    element = ord(board[i][j]) - ord('1')
                    if Bool[element] == True:
                        return False

                    Bool[element] = True

        for block in range(0, 9):
            Bool = [False] * 9
            for i in range((block // 3 * 3), (block // 3 * 3 + 3)):
                for j in range(int(block % 3 * 3), int(block % 3 * 3 + 3)):
                    if board[i][j] != '.':
                        element = ord(board[i][j]) - ord('1')
                        if Bool[element] == True:
                            return False

                        Bool[element] = True

        return True
