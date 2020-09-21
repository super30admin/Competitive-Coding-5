# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        output = []
        
        #level order traversal
        #add all elements to the queue and store each level's node in a temp list
        #add the list's max element to the output list
        
        if not root:
            return 
        
        queue = [root]
        
        while queue:
            size = len(queue)
            temp = []
            for i in range(size):
                front = queue.pop(0)
                temp.append(front.val)
                
                if front.left:
                    queue.append(front.left)
                if front.right:
                    queue.append(front.right)
                    
            output.append(max(temp))
            
        return output