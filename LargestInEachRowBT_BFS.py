# TC: O(N) since we are traversing all the nodes
# SC: O(N/2) or O(N) asymptotically, since the maximum length of the queue at worst case will be no. of leaf nodes in a complete binary tree.

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return 
        
        self.final = []
        
        queue = collections.deque()
        
        queue.append(root)
        while queue:
            size = len(queue) 
            max_val = float('-inf')
            for i in range(size):
                curr = queue.popleft()
                if curr.val > max_val:
                    max_val = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            self.final.append(max_val)
        
        return self.final
