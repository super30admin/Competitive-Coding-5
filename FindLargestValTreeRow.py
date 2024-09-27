#w: BFS based level-order traveseral
#h: we traverse the tree level by level and record the max for each level

import collections
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res = []
        queue = collections.deque([root])
        
        while queue:
            size = len(queue)
            max_ = -float('inf')
            for _ in range(size):
                node = queue.popleft()
                max_ = max(max_, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(max_)
            
        return res