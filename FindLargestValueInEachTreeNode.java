// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
 // BFS APPROACH
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            result.add(max);
        }
        return result;
    }
}*/

// DFS APPROACH
class Solution {
  List<Integer> result;
  public List<Integer> largestValues(TreeNode root) {
    result = new ArrayList<>();
    dfs(root, 0);
    return result;
  }

  void dfs(TreeNode root, int level) {
    // Base
    if(root == null) return;
    // Logic
    if(result.size() == level) {
      result.add(root.val);
    } else {
      int max = Math.max(result.get(level), root.val);
      result.set(level, max);
    }

    dfs(root.left, level+1);
    dfs(root.right, level+1);
  }
}

