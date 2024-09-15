// Time Complexity : O(N)
// Space Complexity : O(N)
//Leetcode problem: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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

        List<Integer> master = new ArrayList<>();

        if(root == null)
            return master;

        List<Integer> temp;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            temp = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            for(int i=0;i<size;i++){

                TreeNode curr = q.poll();

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

                max = Math.max(curr.val, max);

            }

            master.add(max);
        }
        return master;
}
