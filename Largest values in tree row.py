# TC: O(N)
# SC: O(k)
# No problems

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if not root:
            return []
        ans = []
        q = collections.deque()
        q.append(root)
        
        while q:
            q_size = len(q)
            max_val = float('-inf')
            
            for i in range(q_size):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                max_val = max(max_val,curr.val)
            ans.append(max_val)
            
        return ans
               
            
"""
q = 1 ,   3,2,     5,3,9

curr = 9
max_val = 9

ans = [1, 3, 9]

"""