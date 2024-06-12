// Time Complexity : O(N)
// Space Complexity : O(H), where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

public class Find_Largest_Value_DFS {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, 0, result);
		return result;
	}

	private void helper(TreeNode root, int level, List<Integer> result) {
		// base
		if (root == null)
			return;

		// logic
		if (result.size() == level) {
			result.add(root.val);
		} else {
			int m = result.get(level);
			if (root.val > m) {
				result.set(level, root.val);
			}
		}
		helper(root.left, level + 1, result);
		helper(root.right, level + 1, result);
	}
}