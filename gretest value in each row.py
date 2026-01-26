class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root is None:
            return result

        queue=[root]

        while queue:
            max_value=float('-inf')
            size=len(queue)

            for i in range(size):
                curr=queue.pop(0)
                max_value=max(max_value,curr.val)

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            
            result.append(max_value)
        return result