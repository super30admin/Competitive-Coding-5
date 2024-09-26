//Time Complexity - O(n)
//Space Complexity - O(n/2)
//Did the code run on leet code - Yes

//Approach - BFS


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = None
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """  
        
            
        self.result = [] 
        if not root:
            return self.result
        q = deque([root])
        
        while q:            
            qlen = len(q)
            
            maxi = -sys.maxint-1
            
            for i in range(qlen):
                
                curr = q.popleft()
                if(curr.val > maxi):
                    maxi = curr.val
                if curr.left:    
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            self.result.append(maxi)
        return self.result
        
        //Approach - DFS
 //Time Complexity - O(n)
//Space Complexity - O(n/2)
//Did the code run on leet code - Yes
        
        # Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = None
    def largestValues(self, root):
                  
        self.result = [] 
        if not root:
            return self.result
        self.helper(root,0)
        return self.result
    def helper(self,root,level):
        if not root:
            return
        if(level == len(self.result)):
            
            self.result.append(root.val)
        self.result[level] = max(root.val, self.result[level])
        
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
