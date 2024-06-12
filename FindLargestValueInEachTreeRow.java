package competitiveCoding5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
	public class TreeNode {
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
	
	//DFS
	//Time Complexity : O(n), where n is the elements of tree
	//Space Complexity : O(h), where h is the height of internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res, int level) {
        // base
        if(root == null)
            return;
        
        // logic
        if(res.size() == level)
            res.add(root.val);
        else
            res.set(level, Math.max(root.val, res.get(level)));
        
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
    
    //BFS
  	//Time Complexity : O(n), where n is the elements of tree
  	//Space Complexity : O(n), for queue
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}
