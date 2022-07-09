# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # levels = []
        result = []
        if not root:
            return result

        level = 0
        q = collections.deque([root, ])

        while q:
            # levels.append([])
            num_elements_level = len(q)
            maximum = float('-inf')

            while num_elements_level:
                node = q.popleft()
                # levels[level].append(node.val)
                maximum = max(maximum, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                num_elements_level -= 1
            result.append(maximum)
            level += 1

        return result
'''
        levels = []
        if not root:
            return levels

        level = 0
        q = collections.deque([root,])  # or q= deque() \ q.append(root)

        while q:
            levels.append([])
            num_elements_level = len(q)

            while num_elements_level:
                node = q.popleft()
                levels[level].append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                num_elements_level -= 1
            level +=1

        output = []
        for i in range(len(levels)):
            output.append(max(levels[i]))
        return output
'''