// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(H), H = Height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        helper(root, 0, result);
        return result;
    }
    private void helper(TreeNode root, int level, List<Integer> result) {
        //base case
        if(root == null)
            return;
        
        if(level >= result.size())
            result.add(root.val);
        else 
            result.set(level, Math.max(result.get(level), root.val));
        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);
    }
}
                     