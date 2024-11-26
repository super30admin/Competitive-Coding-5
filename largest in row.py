# TC = O(n)
# SC = O(n)
# run on LC

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        output = []
        q = []
        q.append(root)

        if not root:
            return []
        while (q):
            ls = len(q)
            ans = []
            for i in range(ls):
                node = q.pop(0)
                ans.append(node.val)

                if (node.left != None):
                    q.append(node.left)
                if (node.right != None):
                    q.append(node.right)
            output.append(max(ans))

        return output
