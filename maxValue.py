'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        
        que=deque()
        que.append(root)
        res=[]
        while que:
            size=len(que)
            maxi=-float('inf')
            for i in range(size):
                current=que.popleft()
                maxi=max(maxi,current.val)
                if current.left is not None:
                    que.append(current.left)
                if current.right is not None:
                    que.append(current.right)
            res.append(maxi)
        return res