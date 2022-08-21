// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        // base case
        if (root == null) {
            return;
        }
        
        // Logic
        if (level == result.size()) {
            result.add(root.val);
        } else {
            if (result.get(level) < root.val) {
                result.set(level, root.val);
            }
        }
        
        // traverse the left subtree
        dfs(root.left, level + 1);
        
        // Traverse the right subtree
        dfs(root.right, level + 1);
    }
}