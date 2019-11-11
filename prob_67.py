#leetcode 515
#time - O(N)
# space O(N) but an extra temp list will be used instead we can do with a vraible


# Definition for a binary tree node.

# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not (root):
            return []
        q = []
        q.append(root)
        res = []
        tmplst = [q[0].val]
        while q:
            res.append(max(tmplst))
            tmplst = []
            size = len(q)

            for i in range(size):
                curr = q.pop(0)
                if curr.left:
                    q.append(curr.left)
                    tmplst.append(curr.left.val)
                if curr.right:
                    q.append(curr.right)
                    tmplst.append(curr.right.val)
        return res



#Optimal sol
#time - O(N)
# space O(N)

class Solution:
    def largestValues(self, root):
        # edge case
        if not(root):
            return []
        res= []
        q = []
        q.append(root)
        while q:
            temp = -99999999999 # replace this with float('-inf')
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if temp < curr.val: temp = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(temp)
        return res