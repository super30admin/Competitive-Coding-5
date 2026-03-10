### problem 2

# largest value in each row of a tree 
# problem - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        global_arr = []
        if not root:
            return global_arr 
        my_queue = deque()
        my_queue.append(root)
        while(my_queue):
            curr_max = float('-inf')
            arr_length = len(my_queue)
            for _ in range(arr_length):
                curr_node = my_queue.popleft()
                if curr_node.val > curr_max:
                    curr_max = curr_node.val 
                if curr_node.left:
                    my_queue.append(curr_node.left)
                if curr_node.right:
                    my_queue.append(curr_node.right)
            global_arr.append(curr_max)
        return global_arr