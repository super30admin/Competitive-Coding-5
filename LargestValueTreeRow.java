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
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level)
    {
        //Base case
        if (root == null) return;

        //Condition check to find maximum at each level
        if(level < result.size())
        {
            if(result.get(level) < root.val)
            {
                result.set(level, root.val);
            }
        }
        else {
            result.add(level, root.val);
        }

        //Recursion
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}