# Time Complexity: O(n)
# Space Complexity: O(h) - height of tree
# Approach: Do a level order traversal of the tree. At every level record the max node value and append it to the output list.
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
        
        result = []
        q = collections.deque([root])
        
        while q:
            numnodes = len(q)
            largest = float('-inf')
            for _ in range(numnodes):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                largest = max(largest, node.val)
            result.append(largest)
            
        return result