class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:

        res=[]

        if root is None:
            return res

        q = collections.deque()
        q.append(root)
        while q :
            cur = []
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                cur.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            res.append(max(cur))

        return res
