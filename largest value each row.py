# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time : O(N) - traversing each node 
Space : O(H), H = height of tree, worst case O(N), best case O(log N)
'''
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        largestValues_list = []
        self.helper(root,0,largestValues_list) # root, level, ans_list

        return largestValues_list

    def helper(self,node,level,largestValues_list):
        # base
        if node==None:
            return 

        # logic
        if len(largestValues_list) == level: # no node added at this level yet
            largestValues_list.append(node.val) 
        else:
            if largestValues_list[level]<node.val:
                # further bigger element at this level
                largestValues_list[level] = node.val
        self.helper(node.left,level+1,largestValues_list) # left
        self.helper(node.right,level+1,largestValues_list) # right
        
        