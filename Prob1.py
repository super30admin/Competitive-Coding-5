# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        # q=deque()
        # q.append(root)
        # res=[]
        # while q:
        #     max_val=-float("inf")
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         max_val=max(max_val,curr.val)
        #         if curr.left:
        #             q.append(curr.left)
        #         if curr.right:
        #             q.append(curr.right)
        #     res.append(max_val)
        # return res
        res=[]
        def dfs(root,level):
            #base
            if not root: return 
            #logic
            if len(res)==level:
                res.append(root.val)
            else:
                res[level]=max(root.val,res[level])
            if root.left:
                dfs(root.left,level+1)
            if root.right:
                dfs(root.right,level+1)
        dfs(root,0)
        return res

                


        