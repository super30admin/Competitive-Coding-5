class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return 
        
        self.final = []
        
        self.hmap = {}
        def dfs(root, level):
            
            if not root:
                return 
            
            if level == len(self.hmap):
                self.hmap[level] = root.val
            else:
                val = self.hmap.get(level)
                if root.val > val:
                    self.hmap[level] = root.val
            
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        dfs(root, 0)
        
        for i in self.hmap:
            self.final.append(self.hmap.get(i))
        
        return self.final
            
