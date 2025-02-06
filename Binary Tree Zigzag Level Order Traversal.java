// Time complexity: O(N)
// Space complexity: O(N)
// Leetcode: Yes

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //Base
        if(root == null){
            return new ArrayList<>();
        }

        //Logic
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean dir = true;

        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> arr = new LinkedList<Integer>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
               
