# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        #base case
        ans=[]
        if not root:
            return ans
        
        que=collections.deque()
        que.append(root)
        
        while que:
            size=len(que)
            curmax=float("-inf")
            for i in range(size):
                popped=que.popleft()
                curmax=max(curmax,popped.val)
                if popped.left:
                    que.append(popped.left)
                if popped.right:
                    que.append(popped.right)
            
            ans.append(curmax)
        
        
        return ans
        