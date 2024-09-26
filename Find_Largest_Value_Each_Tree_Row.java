import java.util.*;
// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/***********************************************BFS***********************************************/
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity : O(n) , the max number of elements possible in queue are leaf nodes (i.e n/2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using queue to iterate through the elements, and are added in to the queue.
 * traversing through the current node children, we check for maximum value at each level
 * the max value at each level will be added to the resultant list */

class Find_Largest_Value_Each_Tree_RowBFS {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		// edge case
		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int max;

		while(!q.isEmpty()){
			int size = q.size();
			max = Integer.MIN_VALUE;
			for(int i=0; i<size ;i++){
				TreeNode curr = q.poll();
				max = Math.max(curr.val, max);

				if(curr.left != null)
					q.add(curr.left);

				if(curr.right != null)
					q.add(curr.right);

			}
			result.add(max);
		}
		return result;
	}
}

/***********************************************DFS***********************************************/
//Time Complexity : O(n), n is the number of nodes in the tree.
//Space Complexity :O(h) recursion stack space, h is the height of the tree
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No 

/* Using DFS, whenever the size of result array is equal to the level of tree, we append the elements to the result list
 * If the elements at that particular level is already present, then we are checking the max element between the result[level] and root.val */

class Find_Largest_Value_Each_Tree_RowDFS {
	List<Integer> result;
	public List<Integer> largestValues(TreeNode root) {
		result = new ArrayList<>();

		// edge case
		if(root == null)
			return result;

		dfs(root, 0);
		return result;
	}
	private void dfs(TreeNode root, int level){
		if(root == null)
			return;

		if(level == result.size())
			result.add(root.val);
		else
			result.set(level, Math.max(root.val, result.get(level)));

		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}   
}