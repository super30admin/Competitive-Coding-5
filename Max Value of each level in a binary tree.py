'''
TC: O(n)
SC: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # BFS APPRACH
        '''
        if not root:
            return
        res = []
        temp = []
        lvl, prevlvl = 0,0
        q = []
        q.append([root,lvl])
        while q:
            node,lvl = q.pop(0)
            if lvl != prevlvl:
                res.append(max(temp))
                temp = []
            temp.append(node.val)
            prevlvl = lvl

            if node.left:
                q.append([node.left, lvl+1])
            if node.right:
                q.append([node.right, lvl+1])

        res.append(max(temp))
        return res
        '''
        # DFS APPROACH
        res = collections.defaultdict(list)
        output = []
        lvl = 0

        def dfs(node, res, lvl):
            if not node:
                return
            res[lvl].append(node.val)

            dfs(node.left, res, lvl + 1)
            dfs(node.right, res, lvl + 1)

        dfs(root, res, lvl)
        for i in range(len(res)):
            output.append(max(res[i]))
        return output