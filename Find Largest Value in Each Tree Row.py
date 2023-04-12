# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Time Complexity: O(n) where n is the total number of nodes
    # Space Complexity: O(n) where n is the total number of nodes
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # BFS Approach
        # if not root:
        #     return []
        # result = []
        # max_val = -float('inf')
        # Q = collections.deque()
        # Q.append([root,0])
        # lvl = prev_lvl = 0

        # while Q:
        #     curr, lvl = Q.popleft()
        #     if lvl != prev_lvl:
        #         result.append(max_val)
        #         prev_lvl = lvl
        #         max_val = -float('inf')
        #     max_val = max(max_val, curr.val)
        #     if curr.left:
        #         Q.append([curr.left, lvl+1])
        #     if curr.right:
        #         Q.append([curr.right, lvl+1])
        # result.append(max_val)
        # return result

        # DFS Approach
        dic_levels = defaultdict(lambda: -float('inf'))
        def dfs(root, lvl):
            if not root:
                return
            dic_levels[lvl] = max(dic_levels[lvl], root.val)
            dfs(root.left, lvl+1)
            dfs(root.right, lvl+1)
        dfs(root, 0)
        # print(dic_levels)
        return dic_levels.values()


