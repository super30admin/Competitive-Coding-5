""" 
Time Complexity : O(N) N= no.of nodes
Space Complexity :O(m) size of queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
Your code here along with comments explaining your approach
"""

# Approach_1: usng BFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root
        
        q = collections.deque([root])
        result = []

        while q:
            s = len(q)
            max_node = float('-inf')
            for i in range(s):
                node = q.popleft()
                max_node = max(max_node, node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            result.append(max_node)


        return result


# Approach_2: using DFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        """

        TC: O(N)
        SC: O(H) h= height of the tree
        """

        res =[]
        def dfs_helper(root=root, level=0):
            #BASE Case
            if not root:
                return

            if len(res) - 1 < level:
                res.append(root.val)
            else:
                res[level] = max(root.val, res[level])

            dfs_helper(root.left, level + 1)
            dfs_helper(root.right, level + 1)

        dfs_helper()
        return res









