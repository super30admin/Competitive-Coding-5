# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        result = []
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            maximum = float('-inf')

            for i in range(size):
                # For every node from the queue, update if it is the maximum
                curr = q.popleft()
                maximum = max(maximum, curr.val)

                # Append its left and right children to the queue
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            result.append(maximum)

        return result
