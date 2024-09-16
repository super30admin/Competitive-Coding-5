#TC: O(n)
#SC: O(n)

from collections import deque
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class MaxInEachLevel_Queue_BFS(object):
    def largestValues(self, root):
        if (root == None):
            return []
        finalList = []
        queue = deque([root])
        while (len(queue) > 0):
            size = len(queue)
            maximum = float('-inf')

            for i in range(size):
                currNode = queue.popleft()
                if (currNode.left != None):
                    queue.append(currNode.left)
                if (currNode.right != None):
                    queue.append(currNode.right)
                maximum = max(currNode.val, maximum)
            finalList.append(maximum)
        return finalList

class MaxInEachLevel_Recursion_DFS(object):

    def __init__(self):
        self.finalList = []
    def __largestValuesHelper(self, root, level):
        if (root == None):
            return
        if (level == len(self.finalList)):
            self.finalList.append(root.val)
        self.finalList[level] = max(self.finalList[level], root.val)
        self.__largestValuesHelper(root.left, level + 1)
        self.__largestValuesHelper(root.right, level + 1)
        return
    def largestValues(self, root):
        self.__largestValuesHelper(root, 0)
        return self.finalList

