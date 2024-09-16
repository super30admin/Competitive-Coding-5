// Time Complexity : O(N): N = Number of Nodes
// Space Complexity : O(H): H = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FindLargestValueEachTreeRow {
    private List<Integer> op;
    public List<Integer> largestValues(TreeNode root) {
        op = new ArrayList<>();
        //corner cases
        if(root == null) return op;
        dfs(root, 0);
        return op;
    }

    private void dfs(TreeNode root, int level) {

        //base
        if(root == null) return;

        //logic
        if(op.size() == level) {
            op.add(Integer.MIN_VALUE);
        }

        if(op.get(level) < root.val) {
            op.set(level, root.val);
        }

        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}
