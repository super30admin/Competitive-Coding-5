"""BFS Approach"""

#Accepted on Leetcode
#Time complexity- O(n) since each node is touched atleast once
#Space complexity - O(n) using a queue
#Problem faced - Initially i used append instead of extend command which did not allow to push children values into the queue.
# Then I used extend to push the entire children list, it worked.

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
from collections import deque 

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        level = 0
        #Edge case
        if root == None:
            return level
        q = deque()
        q.append(root)
        while len(q) > 0:
            size = len(q)
            level += 1
            for i in range(size):
                curr = q.popleft()
                #print(type(curr))
                if curr.children != None:
                    q.extend(curr.children)
        return level