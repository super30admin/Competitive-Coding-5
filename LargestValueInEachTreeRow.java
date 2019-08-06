package competitveCoding5;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachTreeRow {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int max = Integer.MIN_VALUE;
            //max = Math.max(max, q.poll());
            int level = q.size();
            
            for(int i = 0; i < level; i++) {
                
                TreeNode node = q.remove();
                
                if(node.val > max) {
                    max = node.val;
                }
                
                if(node.left != null) {
                q.add(node.left);
                }
            
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            
             result.add(max);
        }
        return result;
    }
	


	/*
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findMax(root,result,0);
        return result;
    }

    public void findMax(TreeNode root,List<Integer> result,int level){

             if(root==null) return;
        
             if(result.size()==level){
                    result.add(root.val);
                }

            else result.set(level,result.get(level)<root.val?root.val:result.get(level));
        
        findMax(root.left,result,level+1);

        findMax(root.right,result,level+1);

    }
    
    */


}
