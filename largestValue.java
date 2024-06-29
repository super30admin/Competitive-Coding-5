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
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(); // result array
        Queue<TreeNode> q = new LinkedList<>(); // queue for bfs
        q.add(root); // adding root to start of queue
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE; // initialising max value
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val); // compare max with other elemens of same height
                if(curr.left != null){
                    q.add(curr.left); // adding left child
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        result.add(max);
        }

        return result;
    }
}