# Time and space complexity is O(N)
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
        
        if not root:
            return []
        
        q= collections.deque([root])
        result = []
        
        while q:
            resmax = q[0].val
            lenQ = len(q)
            
            for i in range(lenQ):
                node = q.popleft()
                resmax = max(resmax, node.val)
                
                if node.left:
                    q.append(node.left)
                
                if node.right:
                    q.append(node.right)
                    
            result.append(resmax)
        return result
        