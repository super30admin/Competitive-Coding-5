from collections import deque
class Solution(object):
    # Time Complexity: O(n), where n is the number of nodes in the tree.
    # Space Complexity: O(n), space used by the queue
    # Did this code successfully run on Leetcode: yes
    # Any problem you faced while coding this: nope

    # Your code here along with comments explaining your approach

    # This approach uses a BFS where every level is stored in a temporary array
    # and after visiting the entire level, the maximum of that level is added to the result
    def largestValuesBFS(self, root):
        retVal = []
        if not root:
            return retVal

        q = deque()
        q.appendleft(root)

        while len(q) != 0:
            temp = []
            for i in range(len(q)):
                curr = q.pop()
                if curr.left != None:
                    q.appendleft(curr.left)
                if curr.right != None:
                    q.appendleft(curr.right)
                temp.append(curr.val)
            retVal.append(max(temp))

        return retVal

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity: O(n), where n is the number of nodes in the tree.
    # Space Complexity: O(h), where h is the maximum height of the tree.
    # Did this code successfully run on Leetcode: yes
    # Any problem you faced while coding this: nope

    # Your code here along with comments explaining your approach

    # this approach uses a DFS where for every level the maximum is added to the result
    # the level is tracked using the height of every value in the tree.
    def __init__(self):
        self.retVal = []

    def largestValuesDFS(self, root):
        if not root:
            return self.retVal

        self.dfs(root, 0)
        return self.retVal

    def dfs(self, root, height):
        if not root:
            return

        if len(self.retVal) == height:
            self.retVal.append(root.val)
        else:
            self.retVal[height] = max(self.retVal[height], root.val)

        self.dfs(root.left, height + 1)
        self.dfs(root.right, height + 1)
