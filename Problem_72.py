# TC: O(N)
# SC: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        def helper(root, level):
            if not root:
                return
            
            if len(self.res) == level:
                self.res.append([])
            self.res[level].append(root.val)
            helper(root.left, level + 1)
            helper(root.right, level + 1)

        self.res = []
        helper(root, 0)
        temp = []
        for i in self.res:
            temp.append(max(i))
        return temp