# Leetcode problem link : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Time Complexity:    O(n)
# Space Complexity:   O(h) where h is the max elements at one level
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Maintain a queue and do level order traversal(BFS)
    2. For each level keep track of max element and add to output

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        output = []
        
        if not root:
            return output
        
        queue = collections.deque()
        queue.append(root)
        
        while(len(queue) > 0):
            size = len(queue)
            max_level = float('-inf')
            
            for _ in range(size):
                front = queue.popleft()
                max_level = max(front.val,max_level)
                
                if front.left:
                    queue.append(front.left)
                
                if front.right:
                    queue.append(front.right)
            
            output.append(max_level)
        
        return output