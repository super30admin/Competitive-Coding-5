# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: DFS recursive

# The logic is quite simple. Here in the resultant array we will maintain maximum value for each level. So 0th index of resultant array will hold maximum value of 0th level of tree. Now whenever we visit a node, we check for its level and in the resultant array at the levelth index we compare the node's value with the value at that index. If the node's value turns out to be larger than the value at that index will be replace by the node's value. 

# Time Complexity: O(n); n = no of nodes in tree
# Space Complexity: O(h); h = height of the tree

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        self.result = []
        if root == None:
            return self.result
			
        self.dfs(root, 0)
        return self.result
			
		
    def dfs(self,root,level):
        # Base
        if root == None:
            return

        if len(self.result) == level:
            self.result.append(root.val)
        if root.val > self.result[level]:
            self.result[level] = root.val

        # Logic
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

        
# Apporach: BFS iterative


# Logic for this is a little different then DFS. Here we are going to traverse the tree level wise. So we will hold a a variable 'max' that at any point of time will hold the maximum value present at that level. So after we have traversed that level we will just append the latest value of the variable 'max' in the resultant array.

# Time Complexity: O(n); n = no of nodes in tree
# Space Complexity: O(l); l = no of leaf nodes
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if root == None :
            return result
			
        queue = []
        queue.append(root)
		
        while len(queue) != 0:
            size = len(queue)
            maxi = float('-inf')

            for i in range(size):
                curr = queue.pop(0)
                if curr.val > maxi:
                    maxi = curr.val 

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)

            result.append(maxi)

        return result