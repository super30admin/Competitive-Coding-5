# Largest value in each row of the tree

# Aprroach
# Perform BFS on the tree. create a queue and pass root to it. calculate size for each level. At each level, set max to -infinity
# for each node, company the max_Val with curr val. If it is greater, replace max_val. If curr node has left child or right child, add it to queue 
# At end of each iteration, append max_val to result list. return result

# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bfs(self,root):
        q = deque([root])
        while q:
            size = len(q)
            max_val = float(-inf)
            for i in range(size):
                curr = q.popleft()
                max_val = max(max_val,curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            self.res.append(max_val)


    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.res = []
        self.bfs(root)
        return self.res