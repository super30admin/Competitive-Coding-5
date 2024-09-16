#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = []
        res = []
        q.append(root)
        while q:
            n = len(q)
            max_num = float('-inf')
            for index in range(n):
                node = q.pop(0)
                max_num = max(max_num, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(max_num)
        return res