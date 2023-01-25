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
// Time Compexity = O(N)
// Space Complexity = O(N)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List <Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size(); //2
            int max = -2147483648;
            
            for(int i = 0; i< size; i++){
                
                TreeNode curr = q.poll(); //2
                
                if(curr.val > max){ 
                    max = curr.val; 
                }
                
                if(curr.left != null)
                    q.add(curr.left); //5 is added
                if(curr.right != null)
                    q.add(curr.right); //3 is added
                
            }
            
            result.add(max);
        }
        return result;
    }
}