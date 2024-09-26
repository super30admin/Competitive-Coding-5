#time: O(n)
#space: O(m) where m is the no.of leaf nodes
#leetcode:yes

#dfs

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if (root==None):
            return None
        result=[]
        def dfs(root,level):
            if root==None:
                return 
            if(len(result)<=level):
                result.append(root.val)
            else:
                result[level]=max(result[level],root.val)
            dfs(root.left,level+1)
            dfs(root.right,level+1)
        dfs(root,0)
        return result