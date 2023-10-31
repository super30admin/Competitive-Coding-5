# need to level order traversal BFS
# queue with index of root 
# let first element of q be row_max , iterate over to find maximum
# popleft and append children , append level row max
# time complexity 0(n) [visiting each node once] space complexity 0(n) for the queue assuming
# it could be unbalanced


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root :
            return []

       
        q = deque([root])
        
        res = []
        while q :
            row_max = q[0].val
            qLen = len(q)
            for _ in range(qLen):
                node = q.popleft()
                row_max = max(row_max , node.val)
                if node.left :
                    q.append(node.left)
                if node.right :
                    q.append(node.right)
            res.append(row_max)
        return res
           

            