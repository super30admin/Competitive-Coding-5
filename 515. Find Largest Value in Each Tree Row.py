#TC: O(n)
#SC: O(h), height of tree
#DFS recursive solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        def helper(node, depth):
            if node:
                if depth in dic:
                    dic[depth] = max(dic[depth], node.val)
                else:
                    dic[depth] = node.val
                
                helper(node.left, depth+1)
                helper(node.right,depth+1)
                       
        dic = {}
        helper(root,0)
        return dic.values()