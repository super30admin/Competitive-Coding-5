# Time: O(n)
# Space: O(w) The q will have the widest level at a point

# BFS APPROACH

# Add the root in the queue
# Then have a size variable to have the track of the level
# While going through all the elements in the level find which is the maximum one
# Once we find the max element append that to the resultant list and at last return that list
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = deque([root])
        res = []
        if not root: return res

        while q:
            size = len(q)
            maxLev = float('-inf')
            for i in range(size):
                curr = q.popleft()
                maxLev = max(maxLev,curr.val)

                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            res.append(maxLev)
        return res


# Time: O(n)
# Space: O(h) the recursion stack space

# DFS APPROACH

# Do a dfs on the root define an empty array first to keep track of the level with it's index
# Then whenever the len of that array becomes == the level append the current element in the list
# else find the max between the current element and the element present earlier from that level
# At the end return the res array
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        self.helper(root,res,0)
        return res

    def helper(self,root,res,lev):
        if not root: return
        if len(res) == lev:
            res.append(root.val)
        else:
            res[lev] = max(res[lev],root.val)
        self.helper(root.left,res,lev+1)
        self.helper(root.right,res,lev+1)