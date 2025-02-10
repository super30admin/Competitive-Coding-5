# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC - O(n)
# Sc - O(n)
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #base condition or null check
        if root == None:
            return []
        result = []
        queue = deque()
        level = 1
        queue.append(root)
        while len(queue)!=0:
            sublist = []
            size = len(queue)
            for i in range(size):
                currentElement = queue.popleft()
                if currentElement.left:
                    queue.append(currentElement.left)
                if currentElement.right:
                    queue.append(currentElement.right)
                sublist.append(currentElement.val)
            if level%2 == 0:
                result.append(sublist[::-1])
            else:
                result.append(sublist)  
            level+=1    
        return result                  





        
