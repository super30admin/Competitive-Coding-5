# problem 1 : 36. Valid Sudoku : https://leetcode.com/problems/valid-sudoku/
# Time Complexity : O(1) Making 3 loops : one for row, column, and squares. each of it visits all 81 locations
# Space Complexity : O(1) maintaining a list of size = 9
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows, cols = len(board), len(board[0])
        ## checking rows
        for i in range(rows):
            valid = [0] * 9
            for j in range(cols):
                if board[i][j] != '.':
                    if valid[int(board[i][j])-1] == 1:
                        return False
                    else: 
                        valid[int(board[i][j])-1] = 1
            
        ## checking cols
        for i in range(cols):
            valid = [0] * 9
            for j in range(rows):
                if board[j][i] != '.':
                    if valid[int(board[j][i])-1] == 1:
                        return False
                    else: 
                        valid[int(board[j][i])-1] = 1

        ## checking 3*3 square
        for i in range(3):
            for j in range(3):
                valid = [0] * 9
                for r in range(i*3, i*3 + 3):
                    for c in range(j*3, j*3 + 3):
                        if board[r][c] != '.':
                            if valid[int(board[r][c])-1] == 1:
                                return False
                            else: 
                                valid[int(board[r][c])-1] = 1
        return True
  
# problem 2 : 515. Find Largest Value in Each Tree Row : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Time Complexity : O(n) for both dfs and bfs
# Space Complexity : O(n) for dfs and O(D) for bfs where D is maximum diameter of binary tree(which can be n// 2 +1 )
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None   

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        ## bfs
        if not root:
            return []
        ans = []
        de = collections.deque([root])
        while de:
            curr_max = -inf
            for i in range(len(de)):
                node = de.popleft()
                if node.val > curr_max:
                    curr_max = node.val
                if node.left:
                    de.append(node.left)
                if node.right:
                    de.append(node.right)
            ans.append(curr_max)
        return ans
#         ## using dfs
#         if not root:
#             return []
        
#         self.ans = []
#         self.dfs(root,1)
        
#         return self.ans
    
#     def dfs(self, node, level):
#         #base
#         if not node:
#             return 
#         #logic
#         if level > len(self.ans):
#             self.ans.append(node.val)
#         else:
#             if node.val > self.ans[level-1]:
#                 self.ans[level-1] = node.val
#         self.dfs(node.left, level+1)
#         self.dfs(node.right, level+1)
            
            

        