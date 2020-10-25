class Solution(object):
    def largestValues(self, root):
        ans = []
        if root is None:
            return ans
        queue  = [root]
        while queue:
            ans.append(max(x.val for x in queue))
            new_queue = []
            for node in queue:
                if node.left:
                    new_queue.append(node.left)
                if node.right:
                    new_queue.append(node.right)
            queue = new_queue
        return ans
