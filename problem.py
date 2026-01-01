"""
I perform a BFS by keeping the size of q as a limiter for each level and then from those in the queue for the current level, i find the max of it and then append it to the
result. now the remaining child, left and right are in the queue and go through similar operation
TC and SC is O(n) for n nodes in the tree
"""
class Solution(object):
    def largestValues(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        if not root:
            return []
        q = collections.deque()
        res = []
        q.append(root)
        

        while q:
            level = []
            qlen = len(q)
            for _ in range(qlen):
                # maxx = max
                node = q.popleft()
                if node:
                    level.append(node.val)
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
            maxxOfCur = max(level)

            res.append(maxxOfCur)
        return res


        