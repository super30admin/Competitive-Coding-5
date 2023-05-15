#Time Complexity:O(n)
#Space Complexity:O(1)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result=[]
        if root==None:
            return result
        dq=collections.deque()
        dq.append(root)
        while dq:
            ans=float('-inf')
            size=len(dq)
            for i in range(size):
                curr=dq.popleft()
                ans=max(ans,curr.val)
                if curr.left:
                    dq.append(curr.left)
                if curr.right:
                    dq.append(curr.right)
            result.append(ans)
        return result