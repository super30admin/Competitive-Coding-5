#Time complexity: O(n)
#Space complexity: O(n)
#Approach: do level order traversal and add the maximum value of each level to the result list.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #max = 0
        result = []
        if root == None:
            return result
        q = []
        q.append(root)
        while q:
            size = len(q)
            maxnum = -math.inf
            for i in range(size):
                curr = q.pop(0)
                maxnum = max(maxnum, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(maxnum)
        return result
        
        
        