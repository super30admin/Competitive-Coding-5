'''
Time Complexity : 0(n)
Space Complexity : 0(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
- Make a bfs traversal of every level of the binary tree
- add them in queue
- traverse the queue
- and mark level of the queue

'''



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        maxAtEachLevel = []
        
        def bfsTraversal(level):
            if not level:
                return
            queue,maxAtCurrentLevel = [],-float("inf")
            for node in level:
                if node.val>maxAtCurrentLevel:
                    maxAtCurrentLevel = node.val
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            maxAtEachLevel.append(maxAtCurrentLevel)
            bfsTraversal(queue)
        
        if not root:
            return []
        
        bfsTraversal([root])
        return maxAtEachLevel 