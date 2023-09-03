https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : forgot Integer.MIN_VALUE


// Your code here along with comments explaining your approach

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

 //BFS
 class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int size;
        int max;
        if(root == null) return result;

        q.add(root);

        while(q.peek() != null){
            size = q.size();
            max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode temp = q.remove();
                max = Math.max(max, temp.val);
                if(temp.left!= null) q.add(temp.left);
                if(temp.right!= null) q.add(temp.right);
            }
            result.add(max);
        }

        return result;
    }
}