# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# --------------BFS------------------
# T.C. O(N) n is the number of nodes
# S.C. O(N)

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        result=[]
        queue=deque()
        queue.append(root)
        
        while(queue):
            size=len(queue)
            maximum=float('-inf')
            
            for i in range(size):
                curr=queue.popleft()
                maximum=max(maximum,curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(maximum)
        return result

# --------------DFS------------------
# T.C. O(N) n is the number of nodes
# S.C. O(N)

# class Solution:
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
        
#         self.result=[]
#         self.dfs(root,0)
#         return self.result
    
    
#     def dfs(self,root,level):
#         if not root:
#             return
#         if len(self.result)==level:
#             self.result.append(root.val)
#         else:
#             self.result[level]= max(root.val,self.result[level])
        
#         self.dfs(root.left,level+1)
#         self.dfs(root.right,level+1)
        
