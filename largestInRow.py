# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        def helper (node,level):
            if not node:
                return
            if (len(result) ==  level):
                result.append(node.val)
            result[level] =max(node.val, result[level])
            
            helper(node.left, level + 1)
            helper(node.right, level + 1)
        helper(root,0)
        return result