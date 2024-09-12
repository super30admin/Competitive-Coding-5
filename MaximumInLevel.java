// Time Complexity : O(n)
// Space Complexity :O(d) wher d is maximum depth
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> output = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        //edge case
        if(root == null) return output;
        dfs(root,1);
        return output;
        
    }
    private void dfs(TreeNode root, int level)
    {
        //base case
        if(root==null) return;
        if(output.size()<level)
        {
            output.add(root.val);
        }
        else
        {
            if(output.get(level-1)<root.val)
            {
                output.set(level-1,root.val);
            }
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}