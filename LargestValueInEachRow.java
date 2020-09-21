// Time Complexity : O(V) where V is all the vertices in the tree.
// Space Complexity : O(N) where N is the largest number of nodes at any level in the tree.
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : no

import java.util.*;

public class LargestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        
        while(!bfsQue.isEmpty()) {
            int size = bfsQue.size();
            int maxInt = Integer.MIN_VALUE;
            
            while(size-- > 0) {
                TreeNode temp = bfsQue.poll();
                if(temp.val > maxInt) {
                    maxInt = temp.val;
                }
                
                if(temp.left != null) {
                    bfsQue.add(temp.left);
                }
                
                if(temp.right != null) {
                    bfsQue.add(temp.right);
                }
            }
            
            output.add(maxInt);
        }
        
        return output;
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
