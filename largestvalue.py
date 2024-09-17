class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        def helper(root,level):
            if not root:
                return
            if len(ans)==level:
                ans.append(root.val)
            else:
                ans[level]=max(ans[level],root.val)
            helper(root.left,level+1)
            helper(root.right,level+1)
        if not root:
            return []
        ans=[]
        helper(root,0)
        return ans
        