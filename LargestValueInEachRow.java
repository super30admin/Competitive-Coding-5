// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Pushing value when at the first time at a level. For the next time
// compare it with existing value and replace if it's bigger

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LargestValueInEachRow {
    List<Integer> res;

    public List<Integer> largestValues(TreeNode root) {
        this.res = new ArrayList();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int height) {
        // base
        if (root == null) {
            return;
        }

        if (height == res.size()) {
            res.add(root.val);
        }
        // comparisons when we are at levels the second time and onwards
        if (height < res.size()) {
            res.set(height, Math.max(res.get(height), root.val));
        }

        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}