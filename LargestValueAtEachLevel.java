package com.ds.rani.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 111
 * / \
 * 3   21
 * / \   \
 * 5   311  91
 * <p>
 * <p>
 * <p>
 * Output: [111, 21, 311]
 */

//Approach: Use level order traversal and then find largest value at each level
//Time Complexity:o(n) where n is number of nodes in tree
//space Complexity:o(w) where w is maximum width of the tree
public class LargestValueAtEachLevel {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValInEachRow(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add( root );

        while (!queue.isEmpty()) {

            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                maxVal = Math.max( maxVal, current.val );

                //add current nodes children in queue
                if (current.left != null)
                    queue.add( current.left );

                if (current.right != null)
                    queue.add( current.right );
            }
            result.add( maxVal );


        }
        return result;
    }
}

