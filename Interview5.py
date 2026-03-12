#Find Largest Value in Each Tree Row

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        
        resultArray = []

        depth = 0

        self.helper(root, resultArray, depth)
        return resultArray


    def helper(self, root, resultArray, depth):
        

        if depth == len(resultArray):
            resultArray.append(root.val)
        else:
            resultArray[depth] = max(root.val, resultArray[depth])

        if root.left != None:
            self.helper(root.left, resultArray, depth+1)

        if root.right != None:
            self.helper(root.right, resultArray, depth+1)