# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        q = deque()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            maximum = -float('inf')
            for i in range(size):
                curr = q.popleft()
                if curr.val > maximum:
                    maximum = curr.val
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            result.append(maximum)
        return result

# Time Complexity : O(n)
# Space Complexity : O(n/2)


