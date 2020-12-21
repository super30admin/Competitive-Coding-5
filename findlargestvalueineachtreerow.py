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
        # #BFS
        # #O(N)
        # #O(N)
        # q=deque()
        # if not root:
        #     return root
        # q.append(root)
        # res=[]
        # while q:
        #     size=len(q)
        #     level=[]
        #     for i in range(size):
        #         cur=q.popleft()
        #         level.append(cur.val)
        #         if cur.left:
        #             q.append(cur.left)
        #         if cur.right:
        #             q.append(cur.right)
        #     res.append(max(level))
        # return res
    
    
        #DFS
        #O(N)
        #O(h)
        if not root:
            return []
        self.ret = [ ]
        def helper( root, level):
            if root:
                if len(self.ret) == level:
                    self.ret.append(root.val) 
                if self.ret[level]<root.val:
                    self.ret[level]=root.val
                helper(root.left,  level+1)   
                helper(root.right, level+1) 
        helper(root, 0)
        return self.ret  