# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time:O(n) As we are iterating through the whole tree
#Space: O(n) we are using a queue to store all the elements
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        self.ans = []
        queue = deque()
        queue.append((root,0))
        while(queue):
            root,index = queue.popleft()
            if len(self.ans)==index+1:
                self.ans[index]=max(self.ans[index],root.val)
            else:
                self.ans.append(root.val)
            if root.left:
                queue.append((root.left,index+1))
            if root.right:
                queue.append((root.right,index+1))
        return self.ans
        