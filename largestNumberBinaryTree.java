// Time Complexity : O(n)
// Space Complexity : O(h) h is height fo the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

class Solution {
    ArrayList<Integer> result;
    int global_level;
    
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<Integer>();
        
        result=new ArrayList<>();
        global_level=0;
        
        dfs(root,0);
        
        return result.subList(0,global_level+1);
    }
    
    void dfs(TreeNode root, int level)
    {
        // base case
        
        if(root==null)
            return;
       
        result.add(Integer.MIN_VALUE);
        // logic
        
        result.set(level,Math.max(result.get(level),root.val));
        
        // recurse
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        global_level=Math.max(global_level,level);
    }
}