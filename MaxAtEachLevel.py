#All TC on leetcode passed

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:

        #Here we take DFS approach. We append result into res. For each recurrsive call we pass root and level. If size of res is same as level then we add the root value into res. Else we compare cur root val with value at level's index in res and take the max of them.
        #Time - O(n) - where n is all nodes of tree
        #Space compelxity - O(n)
        res = []
        def dfs(root, level):
            #base:
            if not root:
                return 

            #logic:
            if level==len(res):
                res.append(root.val)
            else:
                res[level] = max(res[level], root.val)
            
            if root.left:
                dfs(root.left, level+1)
            if root.right:
                dfs(root.right, level+1)

        dfs(root, 0)
        return res

#---------------------------------------OR---------------------------------------------------------

         #BFS approach
         #Time - O(n) - where n is all nodes of tree
        #Space compelxity - O(h) - queue size max is height of tree
        if not root:
            return []
        res = []
        q = collections.deque()
        q.append(root)

        while q:
            maxvalue = -math.inf
            for i in range(len(q)):
                cur = q.popleft()
                
                maxvalue = max(cur.val, maxvalue)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            res.append(maxvalue)
        return res