// Time Complexity : O(n) --> where n is the number of nodes in the input tree 
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode (515): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // DFS Approach
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        
        // edge case
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        // base case
        if (root == null) return;
       
        // logic
        if (result.size() <= level) result.add(root.val);
        else result.set(level, Math.max(root.val, result.get(level)));
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}