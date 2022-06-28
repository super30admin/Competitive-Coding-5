# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# BFS
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root==None: return result      
        from collections import deque
        q=deque()
        q.append(root)
        result.append(root.val)
        while len(q)!=0:
            maxi=float('-inf')
            for i in range(len(q)):
                curr=q.popleft()
                if curr.left!=None:
                    q.append(curr.left)
                    maxi=max(curr.left.val,maxi)
                if curr.right!=None:
                    q.append(curr.right)
                    maxi=max(curr.right.val,maxi)
            result.append(maxi)
        return result[:-1]
    # DFS
    # Time Complexity: O(n)
    # Space Complexity: O(h)
    # def largestValues(self, root: Optional[TreeNode]) -> List[int]:
    #     result=[]
    #     def dfs(root,result,level):
    #         if root==None: return
    #         if len(result)==level:
    #             result.append(root.val)
    #         result[level]=max(root.val,result[level])
    #         dfs(root.left,result,level+1)
    #         dfs(root.right,result,level+1)
    #     dfs(root,result,0)
        # return result
        