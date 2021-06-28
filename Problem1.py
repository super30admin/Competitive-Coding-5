	# Time Complexity : O(n)
	# Space Complexity : O(n) for bfs and O(h) for dfs
	# Did this code successfully run on Leetcode : Yes
	# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#for each level take the max
from collections import deque
class Solution:
    # def __init__(self):
    #     self.arr = []
    def largestValues(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        # self.dfs(root,0)
        # return self.arr
        queue = deque()
        out = []
        queue.append(root)
        
        while len(queue) != 0:
            size = len(queue)
            maxVal = -9999999999999999999
            for i in range(size):
                node = queue.popleft()
                if maxVal < node.val:
                    maxVal = node.val
                if node.left != None:
                    queue.append(node.left)
                if node.right != None:
                    queue.append(node.right)
            out.append(maxVal)
        return out
                
        
    
    # def dfs(self,root,level):
    #     #edge
    #     if root == None:
    #         return;
    #     #logic
    #     if len(self.arr) < level + 1:
    #         self.arr.append(root.val)
    #     else:
    #         if root.val > self.arr[level]:
    #             self.arr[level] = root.val
    #     self.dfs(root.left,level+1)
    #     self.dfs(root.right,level+1)