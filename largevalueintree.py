# Time complexity: O(m)
#space complexity: o(H) where h is height of tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
      self.result = []
    def largestValues(self, root: TreeNode) -> List[int]:
      self.helper(root,0)
      return self.result
    def helper(self, node, index):
      if not node:
        return
      if len(self.result) <= index:
        self.result.append(node.val)
      else:
        maximum = max(self.result[index], node.val)
        self.result[index] = maximum
      self.helper(node.left,index+1)
      self.helper(node.right,index+1)
