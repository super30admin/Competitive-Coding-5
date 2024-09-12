# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on leetcode

#Approach
#BFS Approach, using a queue and a dynamic size variable iterate over each row
#At the start of each row initialize a max var and append it to the end of result at the end of the row
#DFS approach also possible using a 'row' variable for recursion (if row not encountered, append element to result; if row already encountered, compare the value with result[row] and change if required)




class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        
        result = []
        queue = deque()
        queue.append(root)

        while len(queue):
            size = len(queue)
            curMax = float('-inf')
            while size != 0:
                curNode = queue.popleft()
                curMax = max(curNode.val,curMax)
                if curNode.left:
                    queue.append(curNode.left)
                if curNode.right:
                    queue.append(curNode.right)
                size -= 1
            result.append(curMax)

        return result

            
