# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = list()
        if(root == None):
            return result
        from collections import deque
        q = deque()
        q.append(root)
        while(len(q) != 0):
            l = len(q)
            curr_max = float("-inf")
            for i in range(l):
                curr = q.popleft()
                curr_max = max(curr_max, curr.val)
                if(curr.left != None):
                    q.append(curr.left)
                if(curr.right != None):
                    q.append(curr.right)
            result.append(curr_max)
        return result
            
            
                
            
        