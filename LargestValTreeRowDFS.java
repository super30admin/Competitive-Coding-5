// Time Complexity : O(N)
// Space Complexity : O(1)(O(N) if recursive stack is considered) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        dfs(root, result, 0);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> values, int level){
        //base case
        if(root == null) return;
        if(values.size() <= level){
            values.add(root.val);
        }
        else if(values.get(level) < root.val) {
            values.set(level, root.val);        
        }
      
        dfs(root.left, values, level + 1);
        dfs(root.right,values, level + 1);
    }
}