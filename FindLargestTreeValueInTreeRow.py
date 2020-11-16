#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Performing a BFS, keeping each level distinct by maintaining a for loop, inside the while loop, we keep track of a max value which we keep updating on seeing every new element in that level. At the end of that level, we add the max value in a result array and reinitialize max value at the starting of each level.


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

        q = deque([root])
        result = []

        while q:
            maxi = float("-inf")
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                maxi = max(maxi, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(maxi)

        return result
