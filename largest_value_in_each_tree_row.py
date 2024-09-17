# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
BFS solution
Time complexity: O(n)
Space complexity: O(diameter)
'''
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        queue = [root]
        ans = []
        while queue:
            max = -sys.maxsize - 1
            queue_size = len(queue)
            for i in range(queue_size):
                node = queue.pop(0)
                if node.val > max:
                    max = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(max)
        return ans

'''
DFS solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return
        ans = []
        level = 0
        self.largestValueOnLevel(root, level, ans)
        return ans
            
    def largestValueOnLevel(self, root, level, ans):
        if level == len(ans):
            ans.append(root.val)
        else:
            ans[level] = max(ans[level], root.val)

        if root.left:
            self.largestValueOnLevel(root.left, level + 1, ans)
        if root.right:
            self.largestValueOnLevel(root.right, level + 1, ans)
'''