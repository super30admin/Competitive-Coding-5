import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * 
 */

public class FindLargestValueinEachTreeRow {

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

		List<Integer> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {

				TreeNode curr = q.poll();

				max = Math.max(curr.val, max);
//	                if(i==size-1){
//	                     result.add(max);
//	                 }

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);
			}

			result.add(max);
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
