#time: O(n)
#space: O(m) where m is the no.of leaf nodes
#leetcode:yes

#bfs

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if (root==None):
            return None
        result=[]
        q=deque()
        q.append(root)
        while(q!=deque()):
            maxl=None
            size=len(q)
            for i in range(size):
                node=q.popleft()
                if maxl==None:
                    maxl=node.val
                else:
                    maxl=max(maxl,node.val)
                if node.left!=None:
                    q.append(node.left)
                if node.right!=None:
                    q.append(node.right)
            result.append(maxl)
        return result