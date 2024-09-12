"""
Rasika Sasturkar
Time Complexity: O(n), n is total no. of elements
Space Complexity: O(h), h is max. height of the tree
"""

from collections import deque
from math import inf


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        """
        tree node constructor
        """
        self.val = val
        self.left = left
        self.right = right


def createTree(array_order, index, n):
    """
    Used for constructing a binary tree.
    """
    if array_order is None:
        return None
    root = None
    if index < n and array_order[index] is not None:
        root = TreeNode(val=array_order[index])
        root.left = createTree(array_order, 2 * index + 1, n)
        root.right = createTree(array_order, 2 * index + 2, n)
    return root


class Solution:
    def largestValues(self, root):
        """
        BFS using a queue.
        DFS using recursive stack.
        """
        result = []

        # null case
        if root is None:
            return result

        # Using BFS
        queue = deque([root])
        while queue:
            level = len(queue)
            max_val = -inf
            for i in range(level):
                curr = queue.popleft()
                max_val = max(curr.val, max_val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(max_val)

        # Using DFS
        # def DFS(root, depth):
        #     if root is None:
        #         return result
        #     if len(result) <= depth:
        #         result.append(-inf)
        #     result[depth] = max(root.val, result[depth])
        #     DFS(root.left, depth + 1)
        #     DFS(root.right, depth + 1)
        #
        # DFS(root, 0)

        return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()

    array_order = [1, 3, 2, 5, 3, None, 9]
    root = createTree(array_order, 0, len(array_order))
    print(s.largestValues(root))  # returns [1, 3, 9]

    array_order = [1, 2, 3]
    root = createTree(array_order, 0, len(array_order))
    print(s.largestValues(root))  # returns [1, 3]


if __name__ == "__main__":
    main()
