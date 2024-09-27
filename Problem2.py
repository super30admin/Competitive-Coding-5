# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution1:
    def largestValues(self, root):
        if not root:
            return []
        result = []
        q = [root]
        while q:
            size = len(q)
            max_ = float('-inf')
            for _ in range(size):
                node = q.pop(0)
                max_ = max(max_, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(max_)
        return result

class Solution2:
    result = None 
    def largestValues(self, root):
        self.result = []
        if not root:
            return self.result 
        self.dfs(root,0)
        return self.result 
    
    def dfs(self,root,level):
        # Base 
        if not root:
            return 
        # Logic 
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            key = self.result[level]
            key = max(root.val,key)
            self.result[level] = key 
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)        

if __name__ == "__main__":
    s = Solution2()
    n = Node(1)
    n.left = Node(3)
    n.right = Node(2)
    n.left.left = Node(5)
    n.left.right = Node(3)
    n.right.right = Node(9)
    res = s.largestValues(n)
    print(res)