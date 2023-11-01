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
        # Time: O(N)
        # Space: O(N)
        if not root: return []
        result = [root.val]
        q = collections.deque([root])

        while q:
            iteration = len(q)
            max_val = float("-inf")
            for i in range(iteration):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                    max_val = max(max_val, node.left.val)
                if node.right:
                    q.append(node.right)
                    max_val = max(max_val, node.right.val)
            if max_val != float("-inf"):  result.append(max_val)
        return result

