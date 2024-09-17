// Time Complexity : O(n) 
// Space Complexity : O(heightoftree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Traverse one level at a time.
2. We need a queque,size variable, variable initialised to 
   -infinity and result list.
3. As we start with root in queue, size intitially will be 1
4. If size is greater than zero, process(pop) the node and add 
   its children to queue. 
   tempvariable will be max(temp variable and node val)
   Decrease the size as the node is processed.
5. when size is zero, the level has been processed. 
   add maximum value to result list.
   Initialize temporary variable to infinity and 
   size will length of the queque.

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        
        if root is None:
            return result
        
        
        cq=[]
        tr=-float(inf)
        
        cq.append(root)
        size=1
        
        while(len(cq)!=0):
            
            node=cq.pop(0)
            
            if node.left!=None:
                cq.append(node.left)
                
            if node.right!=None:
                cq.append(node.right)
                
            tr=max(tr,node.val)
            size=size-1
            
            if size==0:
                result.append(tr)
                tr=-float(inf)
                size=len(cq)
                
        return result
        
        