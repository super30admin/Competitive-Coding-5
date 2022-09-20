# Time Complexity: O(n)
# Space Complexity: O(width)

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return
        queue = []
        result = []
        queue.append(root)
        # greatest = -1000
        # result.append(root.val)
        while len(queue) != 0:
            size = len(queue)
            greatest = float(-inf)
            # temp = 0
            for i in range(size):
                root = queue.pop(0)
                greatest = max(greatest, root.val)
                # greatest = max(greatest, root.right.val)
                if root.left != None: 
                    queue.append(root.left)  