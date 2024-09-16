#Time Complexity :o(n)
#Space Complexity :o(m) m is lagetrst element in any level 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if(root==None):
            return []
        
        queue=collections.deque()
        queue.append(root)
        ans=[]
        
        while(queue):
            size=len(queue)
            maxi=None
            for i in range(size):
                curr=queue.popleft()
                if(curr.val>maxi):
                    maxi=curr.val
                if(curr.left!=None):
                    queue.append(curr.left)
                
                if(curr.right!=None):
                    queue.append(curr.right)
            ans.append(maxi)
        return ans