#Time Complexity: O(N).
#Auxiliary Space: O(H)
#Did this code successfully run on Leetcode :Yes

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return root
        
        self.result = []
        level = 0

        def dfs(cur,level):

            
            if len(self.result)==level:
                self.result.append(cur.val)

            else:
                self.result[level] = max(self.result[level],cur.val)
            if cur.left:
                dfs(cur.left,level+1)
            if cur.right:
                dfs(cur.right,level+1)
        
        dfs(root,0)
        
        return self.result
          