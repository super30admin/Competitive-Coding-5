#largest value in a tree row
#time complexity: O(W) where w is the width of the tree
#space complexity: O(N)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        level = [root]
        res = []
        while level:
            next_level = []
            max_level = float("-inf")
            for node in level:
                max_level = max(max_level,node.val)
                if node.left:
                    
                    next_level.append(node.left)
                if node.right:
                
                    next_level.append(node.right)
            res.append(max_level)
            level = next_level
        return res