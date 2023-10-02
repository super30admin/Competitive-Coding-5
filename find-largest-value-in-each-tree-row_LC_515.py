#BFS
#TC:O(N) SC:0(N)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root

        LL=[]
        queue=[]
        queue.append(root) 

        while queue!=[]:
            maximum = 0
            for i in range(len(queue)):
                curr=queue.pop(0) 
                if curr.left!=None: 
                    queue.append(curr.left)
                if curr.right!=None:     
                    queue.append(curr.right)
                maximum = max(maximum, curr.val)
            
            LL.append(maximum)  
                   
        return LL
