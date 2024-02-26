class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        time: O(n)
        space: O(n)
        """
        if not root:
            return []
        q = deque([root])
        ans = []
        while q:
            size = len(q)
            level_max = float("-inf")
            for _ in range(size):
                cur = q.popleft()
                level_max = max(level_max, cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            ans.append(level_max)
        return ans

    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        time: O(1)
        space: O(1)
        """
        col_set = [set() for _ in range(9)]
        square_set = [set() for _ in range(9)]
        for i in range(len(board)):
            row_set = set()
            for j in range(len(board[0])):
                e = board[i][j]
                if e == ".":
                    continue
                square_idx = 3 * (i // 3) + (j // 3)
                if e in row_set or e in col_set[j] or e in square_set[square_idx]:               
                    return False
                row_set.add(e)
                col_set[j].add(e)
                square_set[square_idx].add(e)
        return True 