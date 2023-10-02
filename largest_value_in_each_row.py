# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None:
            return result
        q = deque()
        q.append(root)
        while(len(q) > 0):
            size = len(q)
            rowMax = float("-inf")
            for _ in range(size):
                node = q.popleft()
                rowMax = max(rowMax,node.val)
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
            result.append(rowMax)
        return result

###############################################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root, 0)
        return self.result
    def helper(self, root, level):
        if root == None:
            return
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = max(self.result[level], root.val)
        
        self.helper(root.left, level +1)
        self.helper(root.right, level + 1)
