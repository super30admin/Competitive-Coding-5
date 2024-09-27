#Time complexity is O(N) where N is the number of nodes in the binary tree
#Space complexity is O(M) where M is the maximum number of nodes at any level in the binary tree
#Code ran successfully on leetcode
#Faced no issues while coding this problem

#Find largest value in each row
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
import sys
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #if the root is Null, we will return empty list
        if(root==None):
            return []
        #Creating an empty list -> result for the final output
        result=[]
        #Creating an empty queue and appending the root as the initial value
        q=collections.deque()
        q.append(root)
        #Taking the lowest integer value into the maxi variable
        maxi=-1*sys.maxint
        #Looping through the queue elements
        while(len(q)):
            #Taking the count of the queue such that 
            #we can iterate through the tree level by level
            count=len(q)
            max=maxi
            for i in range(0,count):
                #We will be extracting the values in the queue and 
                #we will be comparing with max value to find the maximum value
                curr=q.popleft()
                if(curr.val>max):
                    max=curr.val
                #If there are left and right nodes for the current node, we will append them to the queue
                if(curr.left!=None):
                    q.append(curr.left)
                if(curr.right!=None):
                    q.append(curr.right)
            #We will appending the maximum value to the result array
            result.append(max)
        #FInally we will be returning the result array
        return result
        