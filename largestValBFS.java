//Time complexity - O(n)
//Space complexity - O(max.breadth of a tree)
//Works on leetcode

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
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            max = Integer.MIN_VALUE;
            // Each level --> storing the max in the result
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            // store the max value in the result
            result.add(max);
        }
       return result; 
    }
}
