# Time Complexity:- O(n)
# Space Complexity:- O(h) h=height of the tree
# Approach:- DFS from the root node increasing the height of the tree and maintaining a res array. If we height is equal to the length of the res array append to it, else we already have a node at the similar height check the index=height of the res array and modify it if this value is greater.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res=[]
        def dfs(root,depth,res):
            if root is None:
                return
            if depth==len(res):
                res.append(root.val)
            else:
                res[depth]=max(root.val,res[depth])
            dfs(root.left,depth+1,res)
            dfs(root.right,depth+1,res)
        dfs(root,0,res)
        return res
        