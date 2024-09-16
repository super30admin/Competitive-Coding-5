#greatest value in each row
# // Time Complexity : O(N)
# // Space Complexity : O(N/2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def largestValues( root):
    if root==None: return []
    queue=[root]
    res=[]
    while(queue):
        size= len(queue)
        maximum = float('-infinity')
        for i in range(size):
            root = queue.pop(0)
            maximum = max(root.val, maximum)                #for every level, check if the current value is greater than the other values at the level
            
            if (root.left):
                queue.append(root.left)
            if (root.right):
                queue.append(root.right)
        res.append(maximum)                                 #after every level, add the maximum value to the list
    return res