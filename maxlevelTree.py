"""
Time - O(N)
Space - O(N)
Leetcode - yes
problems - no
"""

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if(root is None):
            return []
        
        result = []
        queue = []
        
        queue.append(root)
        
        while(len(queue) > 0):
            
            temp = float("-inf")
            size = len(queue)
            
            for i in range(size):
                
                # curr node
                curr = queue.pop(0)
                
                temp = max(temp, curr.val)

                if(curr.left):
                    queue.append(curr.left)
                if(curr.right):
                    queue.append(curr.right)
                            
            result.append(temp)
            
        return result
            
        
        
        