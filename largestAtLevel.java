// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


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
        List<Integer> theList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<> ();

        if(root == null) return theList;

        q.add(root);

        while(!(q.isEmpty())){
            int size = q.size();
            int max = Integer.MIN_VALUE;;
            for(int i = 0; i< size; i++){
                 TreeNode curr = q.poll();
                 max = Math.max(max,curr.val);
                if(curr.left != null)
                q.add(curr.left);
                if(curr.right != null)
                q.add(curr.right);
                
            }
            theList.add(max);
        }
        return theList;
    }
}