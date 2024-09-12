// TC - O(n), SC - O(height of tree) n-> number of elements in tree
// LC - 515
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
// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if(root == null){
//             return res;
//         }
//         int maxAtLevel = Integer.MIN_VALUE;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 TreeNode remNode = q.poll();
//                 maxAtLevel = Math.max(remNode.val, maxAtLevel);
//                 if(remNode.left != null){
//                     q.add(remNode.left);
//                 }
//                 if(remNode.right != null){
//                     q.add(remNode.right);
//                 }
//             }
//             res.add(maxAtLevel);
//             maxAtLevel = Integer.MIN_VALUE;
//         }
//         return res;
//     }
// }


class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return res;
        }
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode node, int level){
        if(node == null){
            return;
        }
        
        if(level == res.size()){
            res.add(node.val);
        }else{
            int maxVal = Math.max(res.get(level), node.val);
            res.set(level, maxVal);
        }
        
        helper(node.left, level+1);
        helper(node.right, level+1);
        
    }
}