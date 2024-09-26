package s30Coding;
import java.util.*;

//Time Complexity :- O(n)

//Space Complexity :- O(h) height of the tree

//LeetCode :- Yes

//Logic :- recursive dfs solution

public class LargestValueInEachRow {
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
	 public List<Integer> largestValues(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if(root == null){
	            return result;
	        }
	        dfs(root, result, 0);
	        return result;
	    }
	    
	    private void dfs(TreeNode root, List<Integer> result, int level){
	        
	        //base
	        if(root == null) return;
	        //logic
	        
	        if(result.size() < level+1){
	           System.out.println(root.val);
	            result.add(level, root.val);
	        }
	        else{
	             
	            if(root.val > result.get(level)){
	                result.remove(level);
	                result.add(level,root.val);
	            }
	        }
	        dfs(root.left, result, level+1);
	        dfs(root.right, result, level+1);
	    }
}
