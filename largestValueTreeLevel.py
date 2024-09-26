# As taught in class I used BFS to find largest node in a binary tree
# Time Complexity: O(n) as we traverse all nodes level by level
# Space Complexity: O(n)
import queue
class Node:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None
class Solution:
    def findLasrgest(self,root):
        result = list()
        if root is None:
            return
        bfsq = list()
        bfsq.append(root)
        while(len(bfsq)!=0):
            max = -99999
            size = len(bfsq)

            for i in range(size):
                node = bfsq.pop(0)
                if node.val > max:
                    max = node.val
                if node.left is not None:
                    bfsq.append(node.left)
                if node.right is not None:
                    bfsq.append(node.right)
            result.append(max)
        return result

    


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)
n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
s = Solution()
r = s.findLasrgest(n1)
print(r)