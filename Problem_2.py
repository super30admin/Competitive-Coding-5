# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC - O(n)
    SC - O(n)
    """
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        ans = []
        q = []
        q.append(root)
        while len(q) > 0:
            size = len(q)
            li = []
            for i in range(size):
                cur = q.pop(0)
                li.append(cur.val)
                if cur.left != None:
                    q.append(cur.left)
                if cur.right != None:
                    q.append(cur.right)
            ans.append(max(li))
        return ans