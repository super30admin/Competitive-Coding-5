# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        res = []
        q = deque()
        level = 0
        
        q.append(root)
        while len(q) != 0:
            size = len(q)
            
            for _ in range(size):
                curr = q.popleft()
                if level == len(res):
                    res.append(curr.val)
                else:
                    res[level] = max(res[level], curr.val)
                    
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            level += 1
        return res