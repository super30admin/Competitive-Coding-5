//Time Complexity : O(N)
// Space Complexity :O(N)

//Approach :
// - take a queue and keep adding levels to the queue and at every 
//level calculate max and add to result list

public class Problem2 {
	  public List<Integer> largestValues(TreeNode root) {
	        
	        List<Integer> result = new ArrayList<>();
	        if(root==null)
	            return result;
	        
	        Queue<TreeNode> que = new LinkedList<>();
	        que.add(root);
	       // int level=1;
	        int max= Integer.MIN_VALUE;
	        while(!que.isEmpty()){
	            int quesize= que.size();
	            
	            for(int i=0;i<quesize;i++){
	                TreeNode node= que.poll();
	                max= Math.max(max, node.val);
	               // System.out.println(max);
	                if(node.left!=null){
	                    que.add(node.left);
	                }
	                
	                if(node.right!=null){
	                    que.add(node.right);
	                }
	            }
	            result.add(max);  
	            max= Integer.MIN_VALUE;
	        }
	          return result;  
	    }
}
