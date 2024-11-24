# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Find Largest Value in Each Tree Row

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #----bfs-----
        result = []
        if root == None:
            return result
        q = [root]
        while q:
            size = len(q)
            currMax = float("-inf")
            for i in range(size):
                curr = q.pop(0)
                currMax = max(currMax, curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            result.append(currMax)
        return result