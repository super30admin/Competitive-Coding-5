// TC: O(n)
// SC: O(n)

// Approach: BFS: Level order traversal is used to just store the 
// max value at each level.

// LC- 515. Find Largest Value in Each Tree Row

import java.util.*;

class TreeNode {
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

public class LargestInEachRowOfBinaryTree {
  List<Integer> result;

  public List<Integer> largestValues(TreeNode root) {
    result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    helper(root, 0);
    return result;
  }

  private void helper(TreeNode node, int level) {
    if (node == null) {
      return;
    }

    if (result.size() == level) {
      result.add(node.val);
    } else {
      result.set(level, Math.max(node.val, result.get(level)));
    }

    helper(node.left, level + 1);
    helper(node.right, level + 1);
  }
}
