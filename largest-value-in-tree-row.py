"""
Runtime Complexity:
O(n) - we perform a BFS, traverse each row and compare with the max val and add it to the result list.
Space Complexity:
O(n) - stack space or result list may end up having 'n' nodes in worst case.
Yes, the code worked on leetcode.
"""
from queue import Queue
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = Queue()
        q = [root]
        result = []
        
        while q:
            max_num = float('-inf')
            for i in range(len(q)):
                node = q.pop(0)
                max_num = max(max_num,node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(max_num)
        return result
                
        
        