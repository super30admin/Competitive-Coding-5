# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Find largest value in each tree row
    
    Time Complexicity: O(n)
    Space Complexicity: O(n)
    
    Approach: Use BFS (level order traversal)
    - create a queue with roo
    - set with a minimum value
    - update the value if above minimum with each going child of previous root (appended to the queue)
    """
    
    def largestValues(self, root: TreeNode) -> List[int]:
            
        result = []
        if root == None: return result
        from collections import deque
        import math
        
        queue = deque(); result = []
        queue.append(root)
        
        while len(queue) != 0:
            
            # initialize list of values at a level
            node_values = [] 
            
            for i in range(len(queue)):
                currNode = queue.popleft()
                currVal = currNode.val
                node_values.append(currVal)
                
                # update the queue for next level
                if currNode.left != None: queue.append(currNode.left)
                if currNode.right != None: queue.append(currNode.right)
                    
            # append max value to results
            result.append(max(node_values))
            
        return result
