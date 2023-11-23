# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        def bfs(root):
            q = collections.deque()
            q.append(root)

            while q: 
                maxVal = -float('inf')
                for _ in range(len(q)): #Level - N
                    node = q.popleft()
                    maxVal = max(maxVal, node.val)
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
                result.append(maxVal) #Appending once - each level
        
        result = []
        bfs(root)
        
        return result