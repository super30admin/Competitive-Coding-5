// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.ArrayList;

public class LargestValueInEachRowOfTree {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        if(root == null)
            return res;

        dfs(root, 0);
        return res;

    }

    private void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(res.size() == level) {
            res.add(root.val);
        }
        else {
            res.set(level, Math.max(root.val, res.get(level)));
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }
}
