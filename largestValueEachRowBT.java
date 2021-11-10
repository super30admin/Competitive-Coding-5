// Time Complexity : O(n) 
// Space Complexity : O(n) -> worst case O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.*;

 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            if (size == 0) {
                break;
            }
            
            while (size != 0) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
            
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
                
                size--; 
            }
            result.add(max);
        }
        return result;
    }
}
