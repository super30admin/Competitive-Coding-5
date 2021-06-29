# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #DFS
        self.res =[]
        def helper(root,level):
            #base
            if root is None:
                return
            #logic
            if level>=len(self.res):
                self.res.append(root.val)
            else:
                if root.val>self.res[level]:
                    self.res[level]=root.val
            helper(root.left,level+1)
            helper(root.right,level+1)
        helper(root,0)
        return self.res
        # implementation of queue in Py
        #BFS
        # if root is None:
        #     return []
        # q = deque()
        # q.append(root)
        # res = []
        # while q:
        #     size = len(q)
        #     maxNum = -1*float('inf')
        #     for i in xrange(size):
        #         node = q.popleft()
        #         if node.val > maxNum:
        #             maxNum = node.val
        #         if node.left is not None:
        #             q.append(node.left)
        #         if node.right is not None:
        #             q.append(node.right)
        #     res.append(maxNum)
        # return res