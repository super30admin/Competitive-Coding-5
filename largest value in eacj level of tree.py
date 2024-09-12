# TC-O(n)
# SC-O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.result = []
        queue = deque()
        queue.append(root)
        maxi = float('-inf')
        while (queue):
            for ele in range(len(queue)):
                cur = queue.popleft()

                maxi = max(maxi, cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            self.result.append(maxi)
            maxi = float('-inf')
        return self.result




