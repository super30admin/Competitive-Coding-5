# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No



import collections
class Solution:
    def largestValues(self, root):
        if not root: return []
        res = []
        
        # to store node values
        queue = collections.deque([root])
        while queue:
            largest = -float('inf')
            for _ in range(len(queue)):
                node = queue.popleft()
                # update the largest value 
                if node.val > largest:
                    largest = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            # add the largest value for each level
            res.append(largest)
        return res