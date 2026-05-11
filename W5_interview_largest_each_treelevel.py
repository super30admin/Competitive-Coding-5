# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        q = deque()


        if root is None:
            return []

        q.append(root)

        while q:
            size = len(q)

            temp_greatest = q[0].val

            for i in range(size):
                curr = q.popleft()

                if curr.val > temp_greatest:
                    temp_greatest = curr.val

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
            result.append(temp_greatest)
        
        return result
            
# Time complexity: O(n) since we visit each node once
# Space complexity: O(n/2) = O(n), where n is the width of the queue at the last level (leaf nodes width of tree)

