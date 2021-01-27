# Time complexity: O(n)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


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
		# Base condition
        if not root or root == None:
            return []
       
	   # append root to queue
        queue = deque()
        queue.append(root)
        result = [] 
        
		# Perform till queue not empty
        while queue:
            queue_len = len(queue)
			
			# Take max_val to compare
            max_val = float("-inf")
            for i in range(queue_len):
                node = queue.popleft()
             
				# Get max value by comparing max_val and node.val
                max_val = max(max_val, node.val)
				
				# Load NODE.LEFT to queue
                if node.left != None:
                    queue.append(node.left)
				
				# Load NODE.RIGHT to queue
                if node.right != None:
                    queue.append(node.right)
            
			# Append my max_val to result
            result.append(max_val)
            
            
        return result
