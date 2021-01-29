# Created by Aashish Adhikari at 7:57 AM 1/29/2021

'''
Time Complexity:
O(n) where n is the number of nodes in the tree

Space Complexity:
In a complete binary tree, the max no of nodes in a level possible at the last level.
So when the last node of  the second last level is being processed, we have (n/2) + 1 nodes in the bfs queue.
O(1 + (n/2)) ~ O(n)
'''


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

        if root is None:
            return []
        sol = []

        from collections import deque
        q = deque()


        q.append(root)
        curr_level = []
        while len(q) != 0:

            for idx in range(0,len(q)):

                curr_level.append(q[0].val)

                if q[0].left is not None:
                    q.append(q[0].left)

                if q[0].right is not None:
                    q.append(q[0].right)
                q.popleft()
            # calc the max of the current level
            sol.append(max(curr_level))
            curr_level = []

        return sol





