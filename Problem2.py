#Time complexity: O(n)
#Space complexity: O(h) where h is the height of the tree
#Works on leetcode: yes
#Approach: We use queue to traverse the tree in level order manner. At each level, we find the maximum value from the list
#and add it to the result. Then we update the queue by assigning children of all the nodes in the queue to the queue itself

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        ans = []
        queue = [root]
        while any(queue):
            ans.append(max(node.val for node in queue if node))
            queue = [child for node in queue for child in (node.left, node.right) if child]
        return ans