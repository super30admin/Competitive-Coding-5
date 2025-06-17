# Time complexity: O(n)
# Space complexity: O(n)


from collections import deque

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        result = []
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            current_max = float('-inf')
            
            for _ in range(level_size):
                node = queue.popleft()
                current_max = max(current_max, node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            result.append(current_max)
        
        return result
