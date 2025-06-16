#Time Complexity: O(N)
#Space Complexity: O(N)

from collections import deque
class Solution(object):
    def largestValues(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []
        if root is None:
            return result
        
        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            max_level = float('-inf')
            for i in range(size):
                node = queue.popleft()
                max_level = max(max_level,node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            result.append(max_level)

        return result