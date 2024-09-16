// Time Complexity : O(n) n is number of nodes 
// Space Complexity :O(max width of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Use BFS level order traversal to keep track of elements in one level.
// at the same time keep updating max element for each level and append to final answer after level is traversed.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if(root==None):
            return([])
        res=[]
        
        q=[]
        
        q.append(root)
        
        while(q):
            
            size=len(q)
            max_ele=-1*float('inf')
            for i in range(size):
                popped=q.pop(0)
                
                if(max_ele<popped.val):
                    max_ele=popped.val
                if(popped.left):
                    q.append(popped.left)
                if(popped.right):
                    q.append(popped.right)
            
            res.append(max_ele)
        
        return(res)
                
                
        