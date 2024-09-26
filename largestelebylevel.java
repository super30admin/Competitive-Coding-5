package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestelebylevel {
	   public List<Integer> largestValues(TreeNode root) {
           List<Integer> res=new ArrayList<>();
        if(root==null) return res;
            
        Queue<TreeNode> q= new LinkedList<>();
     
        q.offer(root);
        while(!q.isEmpty()){
            int max=Integer.MIN_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.val > max) max=curr.val;
                 if (curr.left != null) {
                q.offer(curr.left);
            }
            
            if (curr.right != null) {
                q.offer(curr.right);
            }
                
            }
            res.add(max);
        }
        
        return res;
    }

}
