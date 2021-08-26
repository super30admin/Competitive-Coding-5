#time- O(n) as we have to traverse through all the nodes once 
#space- O(n) using extra space as we are storing maximum node in list
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #DFS
        '''res=[]
        d=0
        self.helper(res,root,d)
        return res
    def helper(self,res,root,d):
        if not root:
            return
        if d==len(res):
            res.append(root.val)
        else:
            res[d]=max(res[d],root.val)
        self.helper(res,root.left,d+1)
        self.helper(res,root.right,d+1)'''
        #BFS
        res=[]
        if not root:
            return res
        #take queue 
        q = deque()
        q.append(root)
        while q:
            max_v=float('-inf')
            
            for _ in range(len(q)):
                node=q.popleft()
                max_v=max(max_v,node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(max_v)
        return res
    
   
