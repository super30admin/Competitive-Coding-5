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

/**
 * TC: O(n)
 * SC: O(n) for queue, worst n when the tree is Skewed.
 * Approach: Do BFS level wise and at each level store the max and at the end just add the max of the level to the result List
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    int level = 0;

    if(root == null) return result;

    q.add(root);

    while(!q.isEmpty()){
        int len = q.size(); 
        int max = Integer.MIN_VALUE; 

        for(int i = 0; i< len; i++){ 
            TreeNode curr = q.poll(); 
            
            max = Math.max(max,curr.val);  

            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        result.add(max);
    }
    return result;   
    }
}