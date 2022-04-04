#Time Complexity : O(n)
#Space Complexity : O(1)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #depthFirstSearch
        self.result = []
        self.helper(root,0)
        return self.result
    
    def helper(self, root,level):
        if(root == None):
            return
        
        if(len(self.result) == level):
            self.result.append(root.val)
        else:
            if(root.val > self.result[level]):
                self.result[level] = root.val
        
        self.helper(root.left,level+1)
        self.helper(root.right, level+1)
    
