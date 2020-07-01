# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #edge case
        if not root:
            return []
        queue = deque()
        queue.append(root)
        sol = []
        #BFS
        while queue:
            size = len(queue)
            #min is -ve inf
            mymax = float("-inf")
            for i in range(size):
                # add left and right and check if current is less greater than max
                curr = queue.popleft()
                if curr.val > mymax:
                    mymax = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            sol.append(mymax)
        return sol