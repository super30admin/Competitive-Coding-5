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

// Approach - BFS
// Time Complexity - O(N) - all the nodes in the tree
// Space Complexity - O(H) - H- height of tree (for storing result)

class Solution {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if(root == null){
      return result;
    }
    bfs(root, result);
    return result;
  }

  public void bfs(TreeNode root, List<Integer> result){

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int maxValue = Integer.MIN_VALUE;

    while(!queue.isEmpty()){

      int size = queue.size();

      for(int i=0; i<size; i++){
        TreeNode node = queue.poll();

        maxValue = Math.max(maxValue, node.val);

        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }
      result.add(maxValue);
      maxValue = Integer.MIN_VALUE;
    }
  }
}