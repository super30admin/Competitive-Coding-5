#515. Find Largest Value in Each Tree Row
# Time Complexity : O(n)
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        queue = collections.deque()
        result = []
        if not root:
            return []
        queue.append(root)
        while queue:
            size = len(queue)
            maxval = float("-inf")
            
            for i in range(size):
                curr = queue.popleft()
                maxval = max(maxval,curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(maxval)
        return result 
#515. Find Largest Value in Each Tree Row
# Time Complexity : O(n)
# Space Complexity :O(h) 
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.d = defaultdict(lambda : float("-inf"))
        
        if not root:
            return []
        self.dfs(root,0)
        return self.d.values()
    def dfs(self,root,level):
        if not root:
            return
        
        self.d[level] = max(self.d[level],root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)