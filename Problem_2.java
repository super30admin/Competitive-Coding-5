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
//Space Compexity: O(n)
//Time Complexity: O(n)
//BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                max=Math.max(curr.val,max);
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}