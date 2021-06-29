# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#DFS       
class Solution:
    def __init__(self):
        # To make the array global
        self.finalList = []
        
    def Helper(self, root, level):
        #   base case check
        if (root == None):
            return []
        #   if level max doesn't exist, create new max
        if (level == len(self.finalList)):
            self.finalList.append(root.val)

        #   if level max already exists, update with new max
        self.finalList[level] = max(self.finalList[level], root.val)

        #   recursion on left subtree and right subtree
        if root.left:
            self.largestValuesHelper(root.left, level + 1)
        if root.right:
            self.largestValuesHelper(root.right, level + 1)

        return

    def largestValues(self, root: TreeNode) -> List[int]:
        #   base case check
        if (root == None):
            return []
         #   main call to the helper recursive functiom
        self.Helper(root, 0)

        #   return the result
        return self.finalList





# BFS
from collections import deque          
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # check None condition 
        if root is None:
            return []
        
        # Create a queue and array to append max at each level
        # Append the root initially in the queue
        q = deque()
        output = []
        q.append(root)
        
        
        while q:
            # We need the size variable to get max at each level
            # We need a max variable to maintain max at each level
            size = len(q)
            maximum = float('-inf')
            
            # loop through each node at the level
            # obtain all the nodes in the queue
            # Compare it with the current maximum
            # Append child nodes inside the queue
            for i in range(size):
                current = q.popleft()
                maximum = max(maximum, current.val)
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)
            
            # Append the maximum value inside the list for each level
            output.append(maximum)
            
        return output
        
        