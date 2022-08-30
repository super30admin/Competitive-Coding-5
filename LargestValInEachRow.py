# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #Since we need to keep a track of every row, BFS makes more sense.
        
        if not root:
            return None
        
        queue=deque([root])
        result=[]
        while len(queue) !=0 :
            size= len(queue)
            #Let temp be a temporary possible minimum number --- check constraints for that
            temp=-2**(31)
            while size != 0:
                node=queue.popleft()
                size-=1
                temp=max(temp, node.val)
                #Appending for the next row
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            result.append(temp)
        return result
        
