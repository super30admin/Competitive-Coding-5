// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelNode {
	List<Integer> ans;

	/********************* DFS *********************/
	public List<Integer> largestValues(TreeNode root) {
		ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		helper(root, 0);

		return ans;
	}

	public void helper(TreeNode root, int level) {
		// Base
		if (root == null) {
			return;
		}
		// Logic
		if (ans.size() <= level) {
			ans.add(root.val);
		} else {
			int max = Math.max(ans.get(level), root.val);
			ans.set(level, max);
		}
		// Recursive Calls
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}

	/********************* BFS *********************/
	public List<Integer> largestValuesBFS(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int n = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
			ans.add(max);
		}

		return ans;
	}

	public static void main(String[] args) {
		MaximumLevelNode obj = new MaximumLevelNode();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);

		List<Integer> maxLevelNodes = obj.largestValues(root);

		for (Integer node : maxLevelNodes) {
			System.out.print(node + " ");
		}
	}

}
