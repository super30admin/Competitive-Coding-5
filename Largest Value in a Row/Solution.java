/**
 * Time Complexity: O(n)
 * Space Complexity : O(k) - k is size of queue
 * Idea:
 * 1. Perform Level order traversal comparing node's values in each level and find the max value
 * Leetcode: yes
 * 
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

class LargestValueInRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> mq = new LinkedList<>();
        // Queue<TreeNode> tq = new LinkedList<>();
        mq.add(root);
       // result.add(root.val);
        while(!mq.isEmpty()){

            int numberOfNodes = mq.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i=0;i<numberOfNodes;i++){
                TreeNode curr = mq.poll();
                if(curr.val > maxValue){
                    maxValue = curr.val;
                }
                if(curr.left != null) mq.add(curr.left);
                if(curr.right != null) mq.add(curr.right);
            }
            result.add(maxValue);
        }
        return result;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("LargestValueInRow");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        LargestValueInRow obj = new LargestValueInRow();
        System.out.println(obj.largestValues(root));
    }
}