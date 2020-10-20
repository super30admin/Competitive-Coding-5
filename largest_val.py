from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return root
        
        result = []
        
        queue = deque()
        queue.append(root)   #[5,3,9]
        while queue:
            temp = []

            for _ in range(len(queue)):
                currentNode = queue.popleft()
                temp.append(currentNode.val) # [3,2]
                
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
                    
            result.append(max(temp)) #[1,3,9]
            
        return result
        
        #tc sc o(n) and o(n/2) === o(n)
