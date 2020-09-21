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
        if root == None:
            return []
            
        output = []
        
        queue = deque()
        queue.append(root)
        
        while(queue):
            size = len(queue)
            highest = float("-inf")
            for i in range(0, size):
                top = queue.popleft()
                if top.val >= highest:
                    highest = top.val
                if top.left is not None:
                    queue.append(top.left)
                if top.right is not None:
                    queue.append(top.right)
            output.append(highest)
        
        return output
