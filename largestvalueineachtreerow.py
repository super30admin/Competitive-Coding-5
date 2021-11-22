# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        maximum = -float('inf')
        arrlist = []
        if not root or root == None:
            return []
        q = collections.deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                poppedItem = q.popleft()
                print(poppedItem.val)
                if poppedItem.val > maximum:
                    maximum = poppedItem.val
                if poppedItem.left != None:
                    q.append(poppedItem.left)
                if poppedItem.right != None:
                    q.append(poppedItem.right)
            arrlist.append(maximum)
            maximum = -float('inf')
        return arrlist



