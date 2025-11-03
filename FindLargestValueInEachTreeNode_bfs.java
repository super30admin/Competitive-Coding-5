// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

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
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return answer;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int maximum = Integer.MIN_VALUE;
            for(int i=0;i<size; i++){
                TreeNode current = q.poll();
                maximum = Math.max(maximum, current.val);
                if(current.left!=null) q.add(current.left);
                if(current.right!=null) q.add(current.right);
                
            }
            answer.add(maximum);
        }
        return answer;
    }
}
