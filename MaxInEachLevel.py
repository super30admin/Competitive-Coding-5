'''
Solution
1.  Using a Queue (BFS), for each level, maintain a size so that one new ArrayList is created and the size number of
    elements are added to that List (or Level).
2.  Using Recursion, add the level as an extra parameter to each recursive call and add the node of corresponding level
    to the corresponding List.
3.  Now, at each level, find the max element and update whenever we find the new maximum corresponding to one level.

Time Complexity: O(n) in all three approaches
Space Complexity: O(n) in BFS and O(h) in DFS and Recursion

--- Passed all testcases on Leetcode successfully

'''

from collections import deque


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class MaxInEachLevel_Queue_BFS(object):

    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   edge case check
        if (root == None):
            return []

        #   initializing the queue
        finalList = []

        queue = deque([root])

        while (len(queue) > 0):
            #   size to keep track of same level elements
            size = len(queue)

            #   default maximum at each level
            maximum = float('-inf')

            for i in range(size):
                currNode = queue.popleft()

                #   add elements to the queue, if children exists
                if (currNode.left != None):
                    queue.append(currNode.left)

                if (currNode.right != None):
                    queue.append(currNode.right)

                #   update the maximum at current level
                maximum = max(currNode.val, maximum)

            #   add current level's maximum to the final result
            finalList.append(maximum)

        #   return the result
        return finalList


class MaxInEachLevel_Recursion_DFS(object):

    def __init__(self):
        self.finalList = []

    def __largestValuesHelper(self, root, level):

        #   base case check
        if (root == None):
            return

        #   if level max doesn't exist, create new max
        if (level == len(self.finalList)):
            self.finalList.append(root.val)

        #   if level max already exists, update with new max
        self.finalList[level] = max(self.finalList[level], root.val)

        #   recursion on left subtree and right subtree
        self.__largestValuesHelper(root.left, level + 1)
        self.__largestValuesHelper(root.right, level + 1)

        return

    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #   main call to the helper recursive functiom
        self.__largestValuesHelper(root, 0)

        #   return the result
        return self.finalList


