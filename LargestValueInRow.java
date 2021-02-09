// Time Complexity : O(n) -> Traverse whole Tree
// Space Complexity : O(2^logn) or ceil(n/2) -> Last Level Fully Filled
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInRow {
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

	class Solution {
		public List<Integer> largestValues(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			if (root == null)
				return result;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				int size = q.size();
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					TreeNode node = q.poll();
					max = Math.max(node.val, max);
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				}
				result.add(max);
			}
			return result;
		}
	}
}
