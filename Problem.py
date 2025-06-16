"""
I used BFS traversal, where I used a queue to add the elements. At each level, I calculated the maximum value and then added the children of the current node to the queue. This process continues until all the nodes are processed.
Time Complexity: O(n)
Space Complexity: O(n) (in the worst case)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        root = 1
        if not root:
            return []
        result = [] 
        queue = deque([root])
        while queue:
            size = len(queue)
            maxNum = float('-inf')
            for _ in range(size):
                currNode = queue.popleft() 
                maxNum = max(maxNum, currNode.val)
                if currNode.left:
                    queue.append(currNode.left)
                if currNode.right:
                    queue.append(currNode.right)
            result.append(maxNum)
        return result    