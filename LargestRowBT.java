// TC: O(N) since we are visiting each every node in the tree
// SC : O(N) for Queue

// At the start, we store the root onto queue and result list , I am traversing each level and retrieving the maximum in each level. Since we are storing all the values in queue for a level,
// we can obtain the maximum value of that level and add that to the list. At the last level, it will again the last level maximum value which we have already added in the previous check, since it is just checking now 
// and it will add the value at the last level again, So we need to remove the last element from the list and return the result list.
 


import java.util.*;

public class LargestRowBT {
	
	public List<Integer> largeRowValue(TreeNode root){
		
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root == null)
			return res;
		
		q.add(root);
		res.add(root.val);
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for(int i= 0 ;i < size;i++) {
				
				TreeNode temp = q.poll();
				if(temp.left!=null) {
					int left = temp.left.val;
					q.add(temp.left);
					max = Math.max(max, left);
				}
				
				if(temp.right != null) {
					int right = temp.right.val;
					q.add(temp.right);
					max = Math.max(max, right);
				}
			}
			res.add(max);
		}
		res.remove(res.size()-1);
		
		return res;	
	}
	
	public static void main(String[] args) {
		
		LargestRowBT lrt = new LargestRowBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		
		System.out.println(lrt.largeRowValue(root));
		
	}

}
