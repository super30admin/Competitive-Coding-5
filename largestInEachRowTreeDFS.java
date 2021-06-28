package CompetitiveCoding5;

//TC - o(n)
//SC - o(n)

import java.util.ArrayList;
import java.util.List;

public class largestInEachRowTreeDFS {
	
	//  Definition for a binary tree node.
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
	 
	    List<Integer> result;
	    public List<Integer> largestValues(TreeNode root) {
	        result = new ArrayList<>();
	        if(root == null) return result;
	        dfs(root,0);
	        return result;
	    }
	    
	    private void dfs(TreeNode root, int level){
	        
	        if(root == null) return;
	        
	        if(level == result.size()){
	            result.add(root.val);
	        }else{
	            if(result.get(level) < root.val){
	                result.set(level, root.val);
	            }
	        }
	        dfs(root.left, level+1);
	        dfs(root.right, level+1);
	    }
	}

