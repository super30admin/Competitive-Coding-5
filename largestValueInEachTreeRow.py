#Time Complexity: O(n) where n is the number of nodes in the tree
#Space Complexity: O(n)
#Did it run on Leetcode: Yes

import sys
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
        queue = [root]
        result = []
        while queue:
            n = len(queue)
            max_ele = -sys.maxsize
            for index in range(n):
                node = queue.pop(0)
                max_ele = max(max_ele, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(max_ele)
        return result
        