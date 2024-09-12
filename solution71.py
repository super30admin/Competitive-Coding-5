#Time Complexity:O(h)
#Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:           
        result=[]                                       #initializing the resultant array
        if not root:                                    #if tree is empty return result
            return result
        d=deque()                                       #initializing the deque
        d.append(root)                                  #append the root in the queue
        while(d):                                       #while the queue is not empty
            m=float('-inf')                             #let m be the max holder curently holding -infinity
            l=len(d)                                    #obtain the length of the queue
            for r in range(l):                          # for evry element of queue within length l
                curr=d.popleft()                        #pop the first element
                if curr.val>m:                          #if the value is greater than current max make it current max
                    m=curr.val
                if curr.left:                           #if the left and right nodes exists append them onto the queue
                    d.append(curr.left)
                if curr.right:
                    d.append(curr.right)
            result.append(m)                            #after each level is processed add its max value to the result
        return result                                   #return the result array
        