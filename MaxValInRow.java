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
/*
algorithm:
traverse level by level and at each level keep track of max element
after that level, add max element to result list

time complexity: O(n), since traversing all nodes
space complexity: O(n/2)
*/
class MaxValInRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<Integer>result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
             int max = Integer.MIN_VALUE;
            for(int i = 0 ;i < size; i++){
               
                TreeNode node = queue.poll();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null)queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            result.add(max);
        }
        return result;
    }
}