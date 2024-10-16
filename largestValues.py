# TC : O(n)  n = number of nodes in the tree 
# SC : O(1)
# all test case on LC : Yes
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root==None : return None 
        resultList = []
        
        from collections import deque  # 
        queue = deque() # pop(), push()
        
        queue.append(root)
        #resultList.push(root.val)
        
        while queue: # only till there are more nodes available 
            size = len(queue); #print(size)
            maxLevel = -1*float('inf')
            # print(resultList)
            
            for i in range(size): # only for the nodes in this level 
                curr = queue.pop() ; # print(curr.val)
                maxLevel = max(maxLevel, curr.val)
                
                if curr.right!=None: 
                    queue.appendleft(curr.right)
                if curr.left!=None:
                    queue.appendleft(curr.left)
                    
            resultList.append(maxLevel)
                
        return resultList 
