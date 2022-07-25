# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity=> O(N)
# Space Complexity => O(N)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if(root is None):
            return []
        queue = []
        result = []
        queue.append(root)
        while(len(queue)!=0):
            size = len(queue)
            max_val = -2**32
            for i in range(size):
                curr = queue.pop(0)
                max_val = max(max_val,curr.val)
                if(curr.left is not None):
                    queue.append(curr.left)
                if(curr.right is not None):
                    queue.append(curr.right)
            result.append(max_val)
        return result
        
        