# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Your code here along with comments explaining your approach
# In the below approach we maintain a max_levels list which maintains the max from each level.
# When we encounter a new level if that level exists we check for max in max_levels and put the max of new value and current level value.
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return
            # global max_levels
        max_levels = []

        def find_max(root,level,max_levels):
            if root == None:
                return

            if (level == len(max_levels)):
                max_levels.append(root.val)

            max_levels[level] = max(max_levels[level],root.val)
            find_max(root.left,level + 1, max_levels)
            find_max(root.right,level + 1, max_levels)


        find_max(root,0,max_levels)
        return max_levels