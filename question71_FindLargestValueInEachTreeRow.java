package CompetitiveCoding5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question71_FindLargestValueInEachTreeRow {
    /* Created by palak on 6/30/2021 */

    /**
     * Definition for a binary tree node.
     */
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

    /*
        Time Complexity: O(n) -> since we are traversing each element in the tree.
        Space Complexity: O(n) -> maximum elemnts at any particular level
    */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if(temp.left != null)   queue.offer(temp.left);
                if(temp.right != null)   queue.offer(temp.right);
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
