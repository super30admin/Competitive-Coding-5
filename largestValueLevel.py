## Approach: BFS
# Time - O(N)
# Space - O(N)
# Similar to level order traversal instead of printing out all the nodes we only add to result the max node value
# Sucessfully ran on leetcode, no problems faced
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        result = []

        if root == None:
            return result

        queue = collections.deque()
        queue.append(root)

        while queue:

            size = len(queue)
            max_value = float("-inf")

            for i in range(size):

                current_node = queue.popleft()
                max_value = max(max_value, current_node.val)

                if current_node.left != None:
                    queue.append(current_node.left)

                if current_node.right != None:
                    queue.append(current_node.right)

            result.append(max_value)

        return result
        

# Approach2: DFS
# Time - O(N)
# Space - O(H)
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        self.result = []
        # base check
        if root == None:
            return self.result

        self.dfs(root, level=0)
        return self.result


        
    def dfs(self, root, level):

        # base check
        if root == None:
            return

        # logic

        if level == len(self.result):
            self.result.append(root.val)
            
        self.result[level] = max(self.result[level], root.val)

        if root.left != None:
            self.dfs(root.left, level + 1)

        if root.right != None:
            self.dfs(root.right, level + 1)
            
            


            

