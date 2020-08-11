# Leetcode 515. Find Largest Value in Each Tree Row

# Time Complexity :  O(n) where n is the number of nodes in the tree

# Space Complexity : 
# DFS :: O(H) where H is the height of the tree
# BFS :: O(n) where n is the number of nodes in the tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: DFS :: Using the length of the result array and level of the tree, if the level of the tree
# and size of the result array match, directly add the node's value to result, else replace the value for that
# level in the result with greater value between the current value and the node val, Then increment the
# level and process the left and right child of the node
# BFS :: For every node in the level, compare the value compare the node's value with maxx and update if its
# greater, after every level add the maxx to result add reset it, once the Q is empty return the result

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS
class Solution:
    result = None
    def largestValues(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        self.result = []
        self.result.append(root.val)
        self.__dfs(root,0)
        
        return self.result
    
    def __dfs(self,node,level):
        if node == None:
            return
        if len(self.result) == level:
            self.result.append(node.val)
        self.result[level] = max(self.result[level],node.val)
        
        self.__dfs(node.left,level+1)
        self.__dfs(node.right,level+1)


# BFS
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        q = deque()
        result = []
        q.append(root)
        maxx = float("-inf")
        
        while q:
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                maxx = max(maxx,node.val)
                
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                    
            result.append(maxx)
            maxx = float("-inf")
        return result