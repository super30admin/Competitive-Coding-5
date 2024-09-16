#Time,space complexity O(n)
class Solution:

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res=[]
    
        if not root:
            return []
 #Calling dfs       
        self.dfs(root,0,res)
        
        return res
   

    def dfs(self,root,level,res):
    
        if not root:
            return []
#Adding the first values at each level to res and then comparing it with other elements and return thr maximum value 
        if len(res)==level:
            res.append(root.val)
        elif root.val>res[level]:
            res[level]=root.val
          
            
        self.dfs(root.left,level+1,res)
        self.dfs(root.right,level+1,res)
