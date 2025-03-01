package findLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TC: O(n)
//SC: O(n)
//approach: BFS

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
class Recursive {
    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, Integer> result = new HashMap();
        findMax(root, 0, result);

        return new ArrayList<>(result.values());
    }

    private void findMax(TreeNode root, int level, HashMap<Integer, Integer> result) {

        if(root == null) {
            return;
        }

        result.put(level, Math.max(root.val, result.getOrDefault(level, Integer.MIN_VALUE)));

        findMax(root.left, level+1, result);
        findMax(root.right, level+1, result);
    }
}