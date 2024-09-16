#TimeComplexity:O(N) 
#SpaceComplexity: MaxDiameter of tree
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return None
        output=[root.val]
        queue=[root]
        while queue:
            queue1=[]
            max1=float('-inf')
            for i in queue:
                if i.left:
                    if i.left.val>max1:
                        max1=i.left.val
                    queue1.append(i.left)
                if i.right:
                    if i.right.val>max1:
                        max1=i.right.val
                    queue1.append(i.right)
            queue=queue1
            if max1!=float('-inf'):
                output.append(max1)
        return output
        
        