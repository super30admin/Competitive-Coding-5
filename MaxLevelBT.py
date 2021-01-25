'''
    Time Complexity:
        O(n) (where n = number of nodes in the Tree)

    Space Complexity:
        O(n) (where n = number of nodes in the Tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS approach.
        At each level maintain a maximum (initliazed with -ve infinity).
        Keep checking the maximum of this level while traversing the level.
        After the visiting the entire level, push the maximum in the output array.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        ans = []

        if not root:
            return ans

        q = collections.deque()
        q.append(root)

        while q:
            level_nodes = len(q)
            max_val = -float('inf')
            i = 0

            while i < level_nodes:
                node = q.popleft()
                max_val = max(max_val, node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

                i += 1

            ans.append(max_val)

        return ans
