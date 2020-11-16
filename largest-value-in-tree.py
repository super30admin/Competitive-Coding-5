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
        if root == None:
            return []
        #         from collections import deque
        #         q=deque()
        #         l=[]
        #         final=[]
        #         q.append(root)
        #         while q:
        #             length=len(q)
        #             l=[]
        #             for i in range(length):
        #                 pop=q.popleft()
        #                 l.append(pop.val)
        #                 if pop.left!=None:
        #                     q.append(pop.left)
        #                 if pop.right!=None:
        #                     q.append(pop.right)
        #             final.append(max(l))

        #         return final
        l = []

        def dfs(root, level):
            if root == None:
                return
            if len(l) == level:
                l.append(root.val)
            else:
                if l[level] < root.val:
                    l[level] = root.val
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        dfs(root, 0)
        return l
        # dfs,bfs -space,time- O(n)