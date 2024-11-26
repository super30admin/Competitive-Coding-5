//Time complexity is o(n) as  we are going through all the elements
//Space complexity is O(n/2) i.e O(n) we have in queue max element is the last level element of queue
//This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN69FindLargestValueinEachTreeRow {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public List<Integer> largestValues(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			// edge
			if (root == null)
				return result;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				Integer max = Integer.MIN_VALUE;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode temp = q.poll();
					if (size == 1) {
						max = temp.val;
					} else {
						if (max <= temp.val) {
							max = temp.val;
						}
					}
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				}
				result.add(max);
				max = Integer.MIN_VALUE;
			}
			return result;
		}
	}
}