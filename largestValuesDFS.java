// Time Complexity :O(n) n is number of leaf nodes
// Space Complexity :O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base case
        if(root == null) return;
        
        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        else{
            if(result.get(level)<root.val){
                result.set(level,root.val);
            }
        }
        
        TreeNode curr = root;
        dfs(root.left,level+1);
        dfs(root.right,level +1);
    }
}