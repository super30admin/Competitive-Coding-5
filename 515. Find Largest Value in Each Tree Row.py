"""
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,null,2]
Output: [1,2]
Example 5:

Input: root = []
Output: []
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
	"""
	Run Time Complexity: O(N)
	Space Complexity: O(N)
	
	Loop through alll the elements by performing the BFS. Take a temp value and update the temp value only and only if there is a value greater than the temp value. Now after complete queue iteration we will get max value in temp. Append the temp to the ans array and retun.
	"""
        if not root:
            return []
        
        queue = deque()
        queue.append(root)
        ans  = []
        while queue:
            temp = -1* sys.maxsize
            for i in range(len(queue)):
                node = queue.popleft()
                if node.val > temp:
                    temp = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(temp)
        return ans
                
        