#Time Complexity : O(N)), N being the number of nodes in the tree. 
#Space Complexity : O(logN), N being the number of nodes in the tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Don't remember but probably had to debug a bit at the 
#end
#Your code here along with comments explaining your approach in three sentences only
'''Using DFS, for each level, create an array keep track of the largest. 
'''
class Solution:
    def helper(self, node, largest, level):
        if node!=None:
            #if there is no value for level, create with value smaller than smallest value. 
            if len(largest)<=level:
                largest.append(-2**32)
            #replace with value of node if value of node is larger. 
            if largest[level]<node.val:
                largest[level]=node.val
            #recurse.
            self.helper(node.left, largest, level+1)
            self.helper(node.right, largest, level+1)

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #initalize and call helper function. 
        largest = []
        level = 0
        if root!=None:
            self.helper(root, largest, level)
        return largest