#Time Complexity : O(N) where N is number of Nodes
# Space Complexity : O(B) maximum breadth 
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.result = []
        if root == None:
            return self.result
        
        def dfs(root,level):
            max1 = float('-inf')
            if root == None:
                return self.result
            if level == len(self.result):
                max1 = max(root.val,max1)
                self.result.append(max1)
            else:
                max1 = max(self.result[level],root.val)
                self.result[level] = max1
            
            dfs(root.right,level+1)
            dfs(root.left,level+1)
        dfs(root,0)
        return self.result
===========================================================================================================
#Time Complexity : O(N) where N is number of Nodes
# Space Complexity : O(H) maximum Height 
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.result = []
        if root == None:
            return self.result
        
        def dfs(root,level):
            max1 = float('-inf')
            if root == None:
                return self.result
            if level == len(self.result):
                max1 = max(root.val,max1)
                self.result.append(max1)
            else:
                max1 = max(self.result[level],root.val)
                self.result[level] = max1
            
            dfs(root.right,level+1)
            dfs(root.left,level+1)
        dfs(root,0)
        return self.result
            
                
            
            
            
        
        