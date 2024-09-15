// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LargestValues {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
  
        dfs(root,0, result);
        return result;
    }
    
    public void dfs(TreeNode root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        
        if(level==result.size()){
            result.add(root.val);
        }else{
            result.set(level,Math.max(result.get(level),root.val));
        }
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
    
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

	}
