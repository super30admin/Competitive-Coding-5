// Time Complexity : O(n) 
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class LargestValue {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result, int l) {
        if(root ==  null) return;

        if(l == result.size()) result.add(root.val);
        else {
            result.set(l, Math.max(result.get(l), root.val));
        }

        helper(root.left, result, l + 1);
        helper(root.right, result, l + 1);
    }
}