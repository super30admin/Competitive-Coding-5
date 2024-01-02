// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -


// Used DFS to traverse through the nodes and updated max value in result list at the position of the level

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LargestValueInTreeRow {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<Integer>();
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(res.size()==level)
            res.add(level,root.val);
        else
            res.set(level, res.get(level)<root.val? root.val: res.get(level));

        helper(root.left,level+1);
        helper(root.right, level+1);

        return;

    }
}