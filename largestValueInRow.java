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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.offer(root);
        if (root == null) return result;
        while(!q.isEmpty()){
            int level = q.size();
            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i < level; i++){
                TreeNode curr = q.poll();
                maxVal = Math.max(maxVal, curr.val);
                if (curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            result.add(maxVal);
        }
        return result;
    }
}