// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(n) where n is number of nodes in tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class LargestValue {
    
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            // at each level keep track of max
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            //add the max to resullt
            res.add(max);
        }
        
        return res;
    }
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
}
