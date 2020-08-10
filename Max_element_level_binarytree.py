class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root==None:
            return []
        max=[]
        def helper(root,level):
            if root==None:
                return 
            if level==len(max):
                max.append(root.val)
            if root.val > max[level]:
                max[level]=root.val
            helper(root.left,level+1)
            helper(root.right,level+1)
        helper(root,0)
        return max

#Time-complexity: O(N)
#Space-Complexity:O(H) H is height of tree