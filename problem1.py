# Space Complexity: O(N)
# Time Complexity: O(N)

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def largestValues(root):
    if not root: return []
    
    q = deque()
    result = []
    q.append(root)
    
    while q: 
        size = len(q)
        max_level = -float('inf')
        for _ in range(size): 
            node = q.popleft()
            if node.val > max_level:
                max_level = node.val
                
            if node.left: 
                q.append(node.left)
            if node.right: 
                q.append(node.right)
        result.append(max_level)
        
    return result

# root = TreeNode(4)
# root.left = TreeNode(9)
# root.right = TreeNode(2)
# root.left.left = TreeNode(3)
# root.left.right = TreeNode(5)
# root.right.right = TreeNode(7)


# result = largestValues(root)
# print(result)  
