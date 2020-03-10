// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;



public class LargestInRowDFS {

	
	List<Integer> res;
	private List<Integer> largestValues(TreeNode root) {
		
		if(root== null)
			return null;
		
		res = new ArrayList<>();
		
		dfs(root, 0);
		return res;
		

	}

	private void dfs(TreeNode root, int depth) {
	
		if(root == null)
			return;
		
		
		if(depth==res.size()) {
			res.add(root.val);
		}else {
			int val = res.get(depth);
			if(root.val>val) {
				res.set(depth, root.val);
			}
		}
		dfs(root.left,depth+1);
		dfs(root.right,depth+1);
		
	
	
	}
	
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

//		root.left.left.left = new TreeNode(3);
//		root.left.left.right = new TreeNode(6);
//
//		root.left.right.left = new TreeNode(11);
//		root.left.right.right = new TreeNode(15);
//
//		root.right.right.left = new TreeNode(32);
//		root.right.right.right = new TreeNode(40);

		LargestInRowDFS l = new LargestInRowDFS();
		List<Integer> res  = l.largestValues(root);
		
		for(int i: res) {
			System.out.println(i);
		}


	}

}
