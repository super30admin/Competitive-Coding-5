// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueAtEveryLevel {

    static class TreeNode {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> bfsQ = new LinkedList<>();

        bfsQ.add(root);

        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = bfsQ.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null) bfsQ.add(curr.left);
                if(curr.right != null) bfsQ.add(curr.right);
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t9 = new TreeNode(9, t5, t1);
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(4, t9, t0);

        System.out.println("Largest values at each level : " + new LargestValueAtEveryLevel().largestValues(t4));
    }
}
