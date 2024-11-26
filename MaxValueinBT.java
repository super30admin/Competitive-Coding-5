
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach
class Solution {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null)
      return res;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      // initialize a max value for each level
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        // compare each value with max for each level
        max = Math.max(curr.val, max);
        if (curr.left != null)
          q.add(curr.left);
        if (curr.right != null)
          q.add(curr.right);
      }
      // add the max value to the res list
      res.add(max);
    }
    return res;

  }
}