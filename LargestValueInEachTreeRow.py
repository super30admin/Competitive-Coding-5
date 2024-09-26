#TC:O(n)
#SC:O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result=[]
        q=[]
        q.append(root)
        if root==None : return result
        idx=0
        while q:
            l=len(q)
            
            for i in range(l):
                curr=q.pop(0)
                if idx==len(result):
                    result.append(curr.val)
                if result[idx]<curr.val:
                    result[idx]=curr.val
                
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
            
            idx+=1
        return result