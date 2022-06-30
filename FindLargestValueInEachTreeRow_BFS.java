/* Time Complexity :O(n)
 * Space Complexity :O(n), for Queue
 * Did this code successfully run on Leetcode :yes
 * Any problem you faced while coding this :No
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>(); 
        //null
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Integer max = Integer.MIN_VALUE;
            for(int i=0; i < size; i++){
                TreeNode node = q.poll();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}