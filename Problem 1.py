# time = O(n)
# space = O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        levels = []
        if not root:
            return levels

        level = 0
        queue = deque([root, ])
        while queue:
            # append empty list to levels->level[0] will have values of level 0 of the tree.
            # levels.append([])

            # find the number of elements that will be there in a level
            level_length = len(queue)
            levels.append([])
            for i in range(level_length):

                node = queue.popleft()
                # if it's the rightmost element

                levels[level].append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            level += 1
        res = []
        print(levels)
        for i in range(len(levels)):
            res.append(max(levels[i]))

        return res