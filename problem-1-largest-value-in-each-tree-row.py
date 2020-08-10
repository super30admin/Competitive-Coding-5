"""
Problem:
https://leetcode.com/problems/find-largest-value-in-each-tree-row/

Approach: BFS Solution

1. Maintain a queue
2. push the root node to the queue. 
3. while popping the nodes from each level from the queue, find the maximum of the popped valeus and add the maximum value to global list

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        res = []
        if root==None:
            return res
        
        que = deque()
        
        que.append(root)
        
        while (que):
            size = len(que)
            maximum = float('-inf')
            for i in range(size):
                cur = que.popleft()
                if (cur.val>maximum):
                    maximum =cur.val
                if(cur.left!=None):
                    que.append(cur.left)
                if(cur.right!=None):
                    que.append(cur.right)
                
            res.append(maximum)
            
        return res


"""
Problem:
https://leetcode.com/problems/binary-tree-level-order-traversal/

Approach: DFS Solution

1. For each node in the tree, store the level information in the recursive stack
2. Maintain a global output list
3. start recursing in the left of the root and if level at a perticular node is equal to the size of the global list, then add that root.val to the global list, else
if level at a node is lesser than than size of the global array , replace the value at the index of level in the gloabl array with the max value bettwen root.val and value at the index equal to level

"""

# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(H) where H is the  height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    res = None
    
    def dfs(self,root, level):
        if root==None:
            return
        if (level==len(self.res)):
            self.res.append(root.val)
        else:
            self.res[level] = max(self.res[level],root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        
    def largestValues(self, root: TreeNode) -> List[int]:
        self.res = []
        
        if root==None:
            return self.res
        
        self.dfs(root,0)
        
        return self.res
        