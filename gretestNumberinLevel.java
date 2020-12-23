// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList();
        
        dfs(root, 0);
        
        return result;
    }
    
    private  void dfs(TreeNode node, int lvl) {
        
        if(node == null)
            return;
        
        if(result.size() <= lvl)
            result.add(node.val);
        else{
            result.set(lvl, Math.max(result.get(lvl), node.val));
        }
        
        dfs(node.left, lvl + 1);
        dfs(node.right, lvl + 1);
        
        
    }
    
}