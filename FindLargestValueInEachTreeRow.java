// Time Complexity: O(n)
// Space Complexity: O(n)  - Level with the most no. of nodes

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        // base
        if (root == null)
            return;

        // logic
        if (level == res.size())
            res.add(root.val);
        else if (root.val > res.get(level))
            res.set(level, root.val);
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }
}