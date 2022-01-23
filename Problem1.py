# Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# // Time Complexity : O(n) where n is the number of nodes in the tree. 
# // Space Complexity : O(n) for BFS and O(h) for DFS where n is the number of nodes in the tree and h is the height of the tree.
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : No.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # result = []
        # if root == None:
        #     return result
        # queue = deque()
        # queue.append(root)
        # while(len(queue) != 0):
        #     size = len(queue)
        #     max = float("-inf")
        #     for i in range(size):
        #         node = queue.popleft()
        #         if node.val > max:
        #             max = node.val
        #         if node.left != None:
        #             queue.append(node.left)
        #         if node.right != None:
        #             queue.append(node.right)
        #     result.append(max)
        # return result
        
        self.result = []
        if root == None:
            return self.result
        
        def helper(root,level):
            # base
            if root == None:
                return 
            
            # logic
            if level == len(self.result):
                self.result.append(root.val)
            else:
                if root.val > self.result[level]:
                    self.result[level] = root.val
            helper(root.left,level + 1)
            helper(root.right,level + 1)
        
        helper(root,0)
        return self.result
