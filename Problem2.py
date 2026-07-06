#https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Time Complexity: O(n), where n is the number of nodes, every node is added and removed from the queue exactly once
# Space Complexity: O(w), where w is the maximum width of the tree, the queue holds at most one full row of nodes at a time
# Approach: use BFS to process the tree one row at a time, for each row snapshot the queue size before the loop
# so we know exactly how many nodes belong to the current row, track the max value seen in that row, then store it

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        # if the tree is empty there are no rows to check, return empty list right away
        if root is None:
            return result
        
        # queue to hold nodes waiting to be processed, we start by putting the root in
        queue = deque()
        queue.append(root)

        # keep looping as long as there are nodes left to process
        while queue:
            # reset max for this new row, using negative infinity so any real node value will be larger
            max_val = float('-inf')

            # snapshot how many nodes are in the queue right now, these are exactly the nodes belonging to the current row.we freeze this count before the loop because we will be adding next row nodes inside the loop
            size = len(queue)

            # process exactly the nodes that were already in the queue for this row, nothing more
            for i in range(size):
                # remove the front node from the queue and look at it
                current = queue.popleft()

                # if this node's value is bigger than what we've seen so far in this row, update the max
                max_val = max(max_val, current.val)
            
                # if this node has a left child, add it to the queue so it gets processed in the next row
                if current.left:
                    queue.append(current.left)
            
                # if this node has a right child, add it to the queue so it gets processed in the next row
                if current.right:
                    queue.append(current.right)

            # after finishing all nodes in this row, store the largest value we found for this row
            result.append(max_val)
        return result