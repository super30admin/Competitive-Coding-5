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

                    //Breadth First Search//
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        //edge case
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        
        return result;
    }
}
//Time Complexity: O(n); n -> number of nodes
//Space Complexity: O(1); h -> height of the tree


            /**Deapth First Search*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level, Math.max(result.get(level), root.val));
        }
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
//Time Complexity: O(n); n -> number of nodes
//Space Complexity: O(1); h -> height of the tree
