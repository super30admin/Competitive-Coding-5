# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we do a bfs and at each level we taek the max value and append it to the result list
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # bfs
        res=[]
        q=[]
        if not root:
            return res
        q.append(root)
        while(len(q)>0):
            size=len(q)
            max_elem=float("-inf")
            for i in range(size):
                popped=q.pop(0)
                max_elem=max(max_elem, popped.val)
                
                if popped.left is not None:
                    q.append(popped.left)
                if popped.right is not None:
                    q.append(popped.right)
            res.append(max_elem)
        return res

        