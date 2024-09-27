# TC==>O(n)
# SC==>O(n)
class Solution:
    def __init__(self):
        self.arr=[]
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root,0)
        return self.arr
    def dfs(self,root,level):
        if root is None:
            return
        if len(self.arr)==level:
            self.arr.append([])
            self.arr[level]=root.val
        else:
            val=self.arr[level]
            if root.val>val:
                self.arr[level]=root.val
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)