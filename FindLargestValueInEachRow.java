// TC: O(n)
// SC: O(h)
// Approach: Using BFS traversal , Maintain a queue
// Declare size and max variables 
// At each level add currentElement to the queue and compare it with max 
// Check for left and right of current element and add to queue if present 
// Add max to result list and return result 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachRow {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> largestValues(TreeNode root) {

    ArrayList<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    // base
    if (root == null)
      return res;

    // logic
    while (!q.isEmpty()) {
      int size = q.size(); // 3
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < size; i++) {

        TreeNode currElement = q.poll();
        max = Math.max(max, currElement.val);

        if (currElement.left != null) {
          q.add(currElement.left);
        }

        if (currElement.right != null) {
          q.add(currElement.right);
        }
      }
      res.add(max);
    }
    return res;
  }
}