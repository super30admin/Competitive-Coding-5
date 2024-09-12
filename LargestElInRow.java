// TIME: O(n)
// SPACE: O(h) where h = height
// SUCCESS on LeetCode

public class LargestElInRow {
    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }
    
    private void dfs(TreeNode node, int level) {
        // base
        if (node == null) return;
       
        if (list.size() == level) {
            list.add(node.val);
        } else {
            int val = list.get(level);
            if (val < node.val) {
                list.set(level, node.val);
            }
        }
        
        // logic
        dfs(node.left, level + 1);
        dfs(node.right, level+1);
    }
}
