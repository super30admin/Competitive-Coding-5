# Time Complexity: O(n)
# Space Complexity: O(n)

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
        res=[]
        if not root:
            return res
        
        def helper(root, level):
            if len(res)<level:
                res.append(root.val)
            else:
                res[level-1]=max(root.val,res[level-1])
            
            if root.left:
                helper(root.left, level+1)
            if root.right:
                helper(root.right, level+1)
        helper(root,1)
        return res
