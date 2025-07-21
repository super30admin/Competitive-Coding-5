'''
515. Find Largest Value in Each Tree Row
Poblem Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
'''

# Time Complexity : O(n) where n is the number of nodes in the tree
# This is because we traverse each node exactly once.
# Space Complexity : O(m) where m is the maximum number of nodes at any level
# Did this code successfully run on Leetcode : Yes, this code runs successfully on Leetcode
# Any problem you faced while coding this : Yes, I faced some issues with understanding how to traverse the tree level by level and how to find the maximum value at each level efficiently.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        '''
        Intuition:
        - Use BFS to traverse the tree level by level
        - For each level, find the maximum value and store it in an answer list
        - Return the answer list at the end
        '''
        if not root: # agar root None hai toh hum empty list return karte hain (if the tree is empty)
            # iska matlab hai ki tree khali hai
            # aur humein koi value nahi mil sakti
            # isliye hum empty list return karte hain
            # yeh base case hai
            return [] # hum empty list return karte hain (then the function will return an empty list)
        ans = [] # yeh list mein hum maximum values store karenge (this list will store the maximum values for each tree row)
        queue = [root]  # Initialize the queue with the root node # hum queue mein root node ko daal rahe hain
        # queue mein hum nodes ko level order traversal ke liye store karte hain
        while queue: # jab tak queue khali nahi hoti (while the queue is not empty)
            level_max = float('-inf') # Initialize the maximum value for the current level to negative infinity kyunki humein maximum value chahiye (we initialize the maximum value for the current level to negative infinity)
            # yeh isliye ki agar level mein koi value nahi hai toh bhi hum maximum value return kar sakein
            next_queue = [] # Initialize the next queue for the next level
            # yeh next_queue mein hum next level ke nodes ko store karenge
            # isse humein next level ke nodes ko process karne mein madad mile
            for node in queue: # hum current level ke nodes par iterate kar rahe hain (we are iterating over the current level nodes)
                # yeh loop current level ke nodes par iterate karega
                # aur unmein se maximum value find karega
                level_max = max(level_max, node.val) # yeh line current node ki value ko level_max ke saath compare karegi aur maximum value ko update karegi (this line will compare the current node's value with level_max and update it if the current node's value is greater)
                # agar current node ki value level_max se zyada hai toh level_max ko update karegi
                # yeh line maximum value ko update karegi
                if node.left: # agar current node ka left child hai toh usse next_queue mein daal do (if the current node has a left child, add it to the next_queue)
                    next_queue.append(node.left) # next_queue mein left child ko daal do 
                if node.right: # agar current node ka right child hai toh usse next_queue mein daal do (if the current node has a right child, add it to the next_queue)
                    next_queue.append(node.right) # next_queue mein right child ko daal do
            ans.append(level_max)  # Append the maximum value of the current level to the answer
            queue = next_queue  # Move to the next level
        return ans  # Return the list of maximum values for each tree row