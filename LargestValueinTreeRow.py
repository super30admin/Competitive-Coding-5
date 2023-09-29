# Time Complexity : O(N)
# Space Complexity : O(N) # N-> number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to iterate level order and find the maximum and store it at then end of the level then return it.

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q=deque()
        q.append(root)
        res=[]
        
        while(len(q)):
            mx=float('-inf')
            n=len(q)
            for i in range(n):
                curr=q.popleft()    
                mx=max(curr.val, mx) 
                if(curr.left):
                    q.append(curr.left)
                if(curr.right):
                    q.append(curr.right)
            res.append(mx)
            
        return res  