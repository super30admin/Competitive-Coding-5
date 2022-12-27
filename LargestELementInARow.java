import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
//Time Complexity : O(n) for traversing the whole matrix
//Space Complexity :O(n) for bfs
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :
public class LargestELementInARow {
	 
    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
       
        if(root==null)
            return result;
        
        int level =0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        result.add(root.val);
       
        
        while(!q.isEmpty()){
            int length = q.size();
            
            for(int i=0;i<length;i++){
                
                TreeNode temp = q.poll();
                
                if(result.size()==level){
                    result.add(temp.val);
                }else{
                    result.set(level,Math.max(result.get(level),temp.val));
                }
                
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right !=null)
                    q.add(temp.right);
            }
            level++;
        }
        
        return result;
        
    }
  //Time Complexity : O(n) for traversing the whole matrix
  //Space Complexity :O(h) for dfs
  //Did this code successfully run on Leetcode :Yes
  //Any problem you faced while coding this : 
    
    
    
  List<Integer> result = new ArrayList<>();
    
    public List<Integer> largestValuesDFS(TreeNode root) {
       
        if(root ==null)
            return result;
        
        helper(root,0);
     
        return result;
    }
    
    public void helper(TreeNode root, int level){
       
        // base         
        if(root==null)
            return;
        // logic
        if(result.size()==level){
            result.add(root.val);
        }
       else{
           result.set(level, Math.max(result.get(level),root.val));
       }
       helper(root.left,level+1);
       helper(root.right,level+1); 
    }
    
    
}
