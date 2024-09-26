// Time Complexity : O(N) - As we traverse through all the nodes of the tree
// Space Complexity : O(N) - As we use a queue data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        List<Integer> arr1 = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return arr1;
        q.add(root);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0;i < size;i++){
            TreeNode temp = q.poll();
            max = Math.max(temp.val,max);
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
           }
            arr1.add(max);
        }
        return arr1;
        
    }
}
// Your code here along with comments explaining your approach