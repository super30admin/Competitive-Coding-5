# Time - O(n)
# Space - O(n)

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        if root is None:
            
            return None
        
        result = []
        
        def helper(root, level):
            
            if root is None:
                return
            
            if level > len(result):
                result.append(root.val)
            
            else:
                
                if (root.val > result[level - 1]):
                    
                    result[level - 1] = root.val
            
            helper(root.left, level + 1)
            helper(root.right, level + 1)
        
        helper(root, 1)
            
        
        return result