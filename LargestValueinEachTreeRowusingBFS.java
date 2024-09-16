//Time complexity :O(n)
//Space Complexity : O(n)
// Using BFS : The best approach for this  problem using BFS wise is because we are checking level wise the program and comparing the both child of tree left and right and it will return the max value of the tree.
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
        if(root == null) return new ArrayList<>();
        int max = 0;
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            max = Integer.MIN_VALUE;
            int level;
            level = q.size();
            for(int i = 0;i<level;i++){
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                
            }
            result.add(max);
        }
        return result;
    }
}