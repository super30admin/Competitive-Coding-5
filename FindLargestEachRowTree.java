import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Time Complexity : O(n)
//Space Complexity : O(n)

public class FindLargestEachRowTree {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	/**Approach: BFS**/
	public List<Integer> largestValues(TreeNode root) {   
        List<Integer> res= new ArrayList<>();
        //null
        if(root==null) return res;
        
        //BFS
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);        
               
        while(!q.isEmpty()){
            int size= q.size();
            int curMax=Integer.MIN_VALUE;
            
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll(); 
                
                curMax= Math.max(curMax, curr.val);                              
                                
                //add children to queue                
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                
            }            
            res.add(curMax);     
        }
        
        return res;
    }

	// Driver code to test above 
	public static void main (String[] args) {
		FindLargestEachRowTree ob = new FindLargestEachRowTree();
    	//TreeNode node= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    	TreeNode node= new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
		    	
		System.out.println("Largest value in each row of tree: "+ob.largestValues(node));
	}
}
