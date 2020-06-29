---------------------------------- Largest Number in a tree row DFS ---------------------------------------------
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(N/2) ~ O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and maintain a depth of the node. When ever the depth is equal than the res array
# we will append the elements into res. If the elements at that particular level is already present then I am checking the max element between the res[level] and root.val.




class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # edge case
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        
        
        def dfs(root, level):
            if not root:
                return 
            
            if level == len(self.res):
                self.res.append(root.val)
            
            self.res[level] = max(self.res[level], root.val)
            
            if root.left:
                dfs(root.left, level+1)
            if root.right:
                dfs(root.right, level+1)
        
        self.res = []
        dfs(root, 0)
        return self.res

---------------------------------- Largest Number in a tree row BFS ---------------------------------------------
# Time Complexity : O(N) N is the number of nodes
# Space Complexity : O(N) worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used a queue to iterate through the elements, and maintained the level at each node. If the level == i the I am appending the max element 
into the res array. else I am checking the max element between the m and root.val element. If curr.left is present appending the left element to the queue,
If right node is present appending right node to the queue.
      
        
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # edge case
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        
        queue = deque()
        queue.append(([root, 0]))
        i = 1
        res = []
        m = float('-inf')
        while queue:
            curr, level = queue.popleft()
            
            if level == i:
                res.append(m)
                m = float('-inf')
                i +=1
            
            m = max(m, curr.val)
            if curr.left:
                queue.append((curr.left, level+1))
            if curr.right:
                queue.append((curr.right, level+1))
        if m :
            res.append(m)
        
        return res