""" 
Time Complexity : O(N) N= no.of nodes
Space Complexity :O(m) size of queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
using BFS 
"""
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
