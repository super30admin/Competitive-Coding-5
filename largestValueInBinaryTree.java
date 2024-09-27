// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # null
        if(root == None):
            return []
        q = []
        retList = []
        q.append(root); #level 0
        while q:
            size = len(q)
            maxNum = -float(inf) # least possible val
            for s in range(size):
                curr = q.pop(0) # elem in current level
                maxNum = max(maxNum, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
            retList.append(maxNum)
        return retList