#Time Complexity : O(n)
#Space Complexity : O(h) 
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #To add the maximum values from each level in a list result
        result=[]
        #Base Case
        if(root==None):
            return result
        #Queue to process the Tree in BFS
        q=deque()
        q.append(root)
        #Runs for each level as an iteration until the tree is completed
        while(len(q)>0):
            #Considered max as -inf instead of 0 as we can compare max values wiht -ve values in the nodes
            maximum = float('-inf')
            for i in range(0,len(q)):
                node = q.popleft()
                if(node.val>maximum):
                    maximum=node.val
                if(node.left!=None):
                    q.append(node.left)
                if(node.right!=None):
                    q.append(node.right)
            result.append(maximum)
        return result