class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        lvals = []
        def traverse_rows(node, row) :
            if not node :
                return
            if len(lvals) == row :
                lvals.append(node.val)
            elif node.val > lvals[row] :
                lvals[row] = node.val
            traverse_rows(node.left, row + 1)
            traverse_rows(node.right, row + 1)      
            
        traverse_rows(root, 0)
        return lvals
