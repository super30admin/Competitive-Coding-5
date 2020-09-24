class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if root== None:
            return None
        
        q = deque([root])
        result = []
        
        
        while q:
        
            maxi = float(-inf)
            
            
            for i in range(0,len(q)):
                
                temp = q.popleft()
                maxi = max(maxi,temp.val)
                
                if temp.left:
                    q.append(temp.left)

                if temp.right:
                    q.append(temp.right)
                    
            result.append(maxi)
                    
        return result
