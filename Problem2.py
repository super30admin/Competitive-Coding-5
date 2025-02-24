# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        arr = []
        level = 0
        self.preorder(root, 0,arr)
        return arr

    def preorder(self, root: Optional[TreeNode],level: int, arr : List[int]):
        if root == None:
            return
        
        #logic
        if len(arr) == level:
            arr.append(root.val)
        else:
            arr[level] = max(arr[level],root.val)

        self.preorder(root.left,level+1,arr)
        self.preorder(root.right,level+1,arr)
        