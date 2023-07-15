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
//Time Complexity = O(N)
//Space Complexity = O(N)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //base

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        int max = Integer.MIN_VALUE;
        // System.out.println(max);
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size ; i++){
                TreeNode curr = q.poll();
                max= Math.max(max,curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

                // System.out.println(max);

            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}