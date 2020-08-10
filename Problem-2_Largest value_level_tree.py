# APPROACH  1: BFS
# Time Complexity : O(n), n: number of nodes of the tree
# Space Complexity : O(n), as a level can have max of n/2 nodes (leaf level)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Visit each node in BFS manner, to maintain level, size var. 
# 2. keep track of max found so far, level-wise
# 3. at the end of a level, add max to the result array. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        queue, result = deque(), []
        queue.append(root)
        while len(queue) > 0:
            size, max_elem = len(queue), float('-inf')
            while size > 0:
                node = queue.popleft()
                max_elem = max(max_elem, node.val)
                
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                size -= 1
                
            result.append(max_elem)
            
        return result
            
        
        

# APPROACH  1: DFS
# Time Complexity : O(n), n: number of nodes of the tree
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Visit each node in recursive DFS manner, to maintain level, locally pass in each call along with the current node
# 2. keep track of max found so far, level-wise -> if level same as size of result means the level is not processed so add element to the result. if level < size of result array
#    means the level is already visited, so compare the current node's value and the element at the corresponding level ind


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, node, level):
        if node is None:
            return 
        
        if level == len(self.result):
            self.result.append(node.val)
        elif level < len(self.result):
            self.result[level] = max(self.result[level], node.val)
            
        self.dfs(node.left, level + 1)
        self.dfs(node.right, level + 1)
        
