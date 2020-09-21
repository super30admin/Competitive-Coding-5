 # Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

 #dfs
 def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def dfs(root, ans, level):
            if root is None:
                return 0
            
        
            if level == len(ans):
                ans.append(root.val)
            else:
                num = ans[level]
                if num < root.val:
                    ans[level] = root.val
            
            
            
            dfs(root.left, ans, level + 1)
            dfs(root.right, ans, level + 1)
        
       
        ans = []
        mx = float('-inf')
        dfs(root, ans, 0)
    
        return ans
    
#bfs
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return
        queue = [root]
        res = []
        ans = []
        
        while queue:
            nodeCount = len(queue)
            mx = float('-inf')
            while nodeCount > 0:
                node = queue.pop(0)
                if node.val > mx:
                    mx = node.val
                #res.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                nodeCount -= 1
            ans.append(mx)
        return ans
        