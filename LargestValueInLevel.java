import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(N)
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/**
 * Apply Level order traversal which is BFS. when the result list size is equal to 
 * level of the tree update the list with the highest value till then. then return 
 * the final list.
 */
class Pair {
	TreeNode node;
	int level;

	public Pair(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}

class Solution {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			if (pair.level == ans.size()) {
				ans.add(pair.node.val);
			} else if (pair.level < ans.size()) {
				ans.set(pair.level, Math.max(ans.get(pair.level), pair.node.val));
			}
			if (pair.node.left != null)
				queue.add(new Pair(pair.node.left, pair.level + 1));
			if (pair.node.right != null)
				queue.add(new Pair(pair.node.right, pair.level + 1));
		}

		return ans;
	}
}