# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we use dfs and also pass the level of the node and check if that value is the max
# at that level
class Solution:
    # DFS Solution
    def __init__(self):
        self.values = list()

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:

        self.dfsCheck(root,0)
        return self.values

    def dfsCheck(self,root,level):
        if root==None:
            return
        if len(self.values)-1<level:
            self.values.append(root.val)
        else:
            self.values[level]=max(self.values[level],root.val)

        self.dfsCheck(root.left,level+1)
        self.dfsCheck(root.right,level+1)

    # BFS Solution
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         if root==None:
#             return []
#         values = list()
#         queue = list()
#         queue.append(root)

#         while len(queue)!=0:
#             size = len(queue)
#             currM = queue[0].val
#             for i in range(size):
#                 curr = queue.pop(0)
#                 if curr.left!=None:
#                     queue.append(curr.left)
#                 if curr.right!=None:
#                     queue.append(curr.right)
#                 currM = max(currM,curr.val)
#             values.append(currM)
#         return values