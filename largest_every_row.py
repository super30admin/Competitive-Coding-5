# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We do a BFS traversal of the tree. Every time we are at a new level, we add the first element value to the return list as max value for the row. 
#If we are processing in the same level, then we check if the current popper value is greater than existing max value stored - if it is, then we replace it.
#Finally we return the return list

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None :
            return []
        self.queue = []
        return_list = []
        self.queue.append((root,0))
        return_list.append(root.val)
        prev_level = 0

        while (len(self.queue) != 0):
            curr_elem = self.queue.pop(0)
            tree_node = curr_elem[0]
            node_level = curr_elem[1]

            if node_level == prev_level :
                if tree_node.val > return_list[-1]:
                    return_list [-1] = tree_node.val
            elif node_level > prev_level :
                return_list.append(tree_node.val)

            if tree_node.left != None :
                self.queue.append((tree_node.left,node_level+1))
            if tree_node.right != None :
                self.queue.append((tree_node.right,node_level+1))
            
            prev_level = node_level

        return return_list
