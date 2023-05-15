// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) (or O(n) in case of skewed tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We do a level order traversal (using DFS in this case) in order to
 * determine the largest value in each level (which is also called a tree row).
 */

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

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if(root == null) {
            return;
        }
        // logic
        // 1. check whether the value at level exists
        if(res.size() <= level) {
            // 2. if not, add
            res.add(root.val);
        } else {
            // 3. otherwise check and update max
            res.set(
                level, // index
                Math.max(res.get(level), root.val) // value
            );
        }
        // 4. DFS left and right
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
