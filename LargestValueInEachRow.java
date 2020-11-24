import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LargestValueInEachRow {
	  List<Integer> largestValues;
	    public List<Integer> largestValues(TreeNode root) {
	        
	        largestValues = new LinkedList();
	        //edge cases
	        if(null==root)
	            return largestValues;
	        
	        Queue<TreeNode> que = new LinkedList<TreeNode>();
	        que.add(root);
	        
	        while(!que.isEmpty()){
	            
	            int n = que.size();
	            int largeVal = Integer.MIN_VALUE;
	            //n=2
	            for(int i = 0;i<n;i++){
	                TreeNode curr = que.poll();
	                if(curr.val>largeVal)
	                    largeVal = curr.val; // now you got largestvalue of particular level
	                //whether they have children or not
	                if(curr.left!=null)
	                    que.add(curr.left);
	                
	                if(curr.right!=null)
	                    que.add(curr.right);   
	                
	            }
	            largestValues.add(largeVal);   // add to result linked list 
	            
	        }
	        
	        return largestValues;
	        
	        
	    }
	}
}
