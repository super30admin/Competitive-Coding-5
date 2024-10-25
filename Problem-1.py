#T.C = O(n) S.C = O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []
        if(root is None):
            return result

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            maximum = -99999999999999999
            for i in range(size):
                curr = q.popleft()
                maximum = max(maximum,curr.val)
                if(curr.left is not None):
                    q.append(curr.left)
                if(curr.right is not None):
                    q.append(curr.right)

            result.append(maximum)

        return result
        