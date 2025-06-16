# TC: O(n)
# SC: O(n)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q=deque([])
        q.append(root)
        lvlmax=[]
        if not root:
            return []
        while q:
            size=len(q)
            lvlmax.append(-float('inf'))
            for i in range(size):
                curr=q.popleft()
                lvlmax[-1]=max(lvlmax[-1], curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        
        return lvlmax