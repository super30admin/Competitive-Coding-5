# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) , traverse through each node of that level to chekc max
    # sc : O(n), in a balanced tree every time we will have n/2 nodes in a level which is O(n)
    def largestValues(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # will traverse usign a bfs, keep a queue for each level and check which is max in this level and add that max in the output arr

        result = []
        q = deque()

        q.append(root)

        while q:
            size = len(q)
            max_in_level = float("-inf") # the value in the nodes can be -ve as well so will intiate the max as -inf instead of 0
            for i in range(size):
                node = q.popleft()
                if node.val > max_in_level:
                    max_in_level = node.val
                
                if node.left is not None :
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
            
            # we found the max value in this level and have added it into the result
            result.append(max_in_level)

        return result
