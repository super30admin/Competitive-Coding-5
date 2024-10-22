'''
    Time Complexity: O(n)
    Space Complexity: O(n/2)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        # base case
        if not root:
            return

        # logic
        if level < len(self.result):
            maximum = max(self.result[level], root.val)
            self.result[level] = maximum
        else:
            self.result.append(root.val)

        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
                
