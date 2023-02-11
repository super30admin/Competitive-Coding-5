#TimeComplexity :- O(2^n)
# Space Complexity :- O(h) queue space



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        max = []
        queue = []
        
        if root is None:
            return max
        queue.append(root)
        max.append(root.val)
        while(len(queue) > 0):
            size = len(queue)
            maxElement = None
            print(size)
            for i in range(size):
                curr = queue.pop(0)
                if curr.left is not None:
                    if maxElement is None:
                        maxElement = curr.left.val
                    elif curr.left.val > maxElement:
                        maxElement = curr.left.val
                    queue.append(curr.left)
                if curr.right is not None:
                    if maxElement is None:
                        maxElement = curr.right.val
                    if curr.right.val > maxElement:
                        maxElement = curr.right.val
                    queue.append(curr.right)
            if len(queue) >0:            
                max.append(maxElement)
        return max


                


        