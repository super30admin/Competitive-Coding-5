import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(L) where is L is level
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this : getting started with the BFS

// Your code here along with comments explaining your approach

public class MaxValueBinaryTree {

    /**
     * Definition for a binary tree node.
     * */
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
            List<Integer> values = new ArrayList<Integer>();
            if(root == null) return values;
            //create queue and add root to it
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                int maxValue = Integer.MIN_VALUE;
                while(size>0){
                    TreeNode node = q.poll(); // pop top value or if empty return null
                    maxValue = Math.max(maxValue, node.val); //get max value
                    if(node.left != null) q.add(node.left); //add left node to queue
                    if(node.right != null) q.add(node.right); //add right node to queue
                    size--;
                }
                values.add(maxValue); //add max value to list
            }
            return values;
        }
    }
}
