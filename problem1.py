 Find Largest Value in Each Tree Row

// Time Complexity :O(n)
// Space Complexity :O(n)//max depth or number of nodes
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        output=[]
        stack=[]
        stack.append((0,root))
        
        while len(stack)!=0:    //traverse till stack is not  (preorder traversal)
            level,front=stack.pop()   //pop the last element
            size=len(output)        //compute length of output list
            if size > level:      //if size of list is > level of node ie, if current index exist in output list => store the maximum value at that index
                output[level]=max(output[level],front.val)    
            else:                       //if the index does not exist => append the root.val at last index
                output.append(front.val)  
            if front.right:             //if front.right => append it in stack
                stack.append((level+1,front.right))
            if front.left:        //if root.right => append it in stack
                stack.append((level+1,front.left))
                
            
        return output
            
