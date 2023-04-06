#TC-O(n)
#SC-O(n)
#Logic-level oreder traversal using bfs and keep track of elements in each level, find their max
#and append to the result
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return
        result = []
        level=[root]
        result.append(root.val)
        while level:
            s=len(level)
            clevel=[]
            for i in range(s):
                x=level.pop(0)
                if x and x.left:
                    clevel.append(x.left.val)
                    level.append(x.left)
                if x and x.right:
                    clevel.append(x.right.val)
                    level.append(x.right)
            print(clevel)
            if clevel:
                m = max(clevel)
                result.append(m)
        return result
                
