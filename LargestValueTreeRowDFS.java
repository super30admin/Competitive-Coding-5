import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(h), where h - height
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LargestValueTreeRowDFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        if(root == null){
            return retVal;
        }
        
        dfs(root, 0, retVal);
        return retVal;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> retVal){
        if(root == null){
            return;
        }
        
        if(retVal.size() == level){
            retVal.add(root.val);
        }
        else{
            int max = Math.max(root.val, retVal.get(level));
            retVal.set(level, max);
        }
        
        dfs(root.left, level + 1, retVal);
        dfs(root.right, level + 1, retVal);
    }
}