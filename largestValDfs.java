// Time complexity - O(n)
// Space Complexity - O(max.length of the tree)
// Works on leetcode

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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList();
        int level = 0;
        dfs(root, level, result);
       return result;
    }
    private void dfs(TreeNode node, int level, List<Integer> result){
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(node.val);
        }
        else{
            if(node.val > result.get(level)){
                result.set(level, node.val);
            }
        }
        dfs(node.left, level+1, result);
        dfs(node.right, level+1, result);
    }
}
