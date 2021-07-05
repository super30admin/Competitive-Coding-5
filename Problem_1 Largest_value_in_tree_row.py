# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        self.helper(result, root, 0)
        return result

    def helper(self, result, root, level):
        if root == None:
            return
        if len(result) == level:
            result.append(root.val)
        else:
            result[level] = max(result[level], root.val)

        self.helper(result, root.left, level + 1)
        self.helper(result, root.right, level + 1)

