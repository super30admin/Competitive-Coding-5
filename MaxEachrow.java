// Time Complexity : O(N) 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * 1. It is BFS solution
 * 2. Visit each level and find max integer and add it to list
 * 3. queue will be the aux space
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaxEachrow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int max = Integer.MIN_VALUE;
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(max);
		}
		return result;
	}
}

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
