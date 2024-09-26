//Find the largest value in each level and add it to list
import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        if(root == null){
            return l;
        }
        Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int siz = q.size();
            for(int i = 0; i < siz; i++){
                TreeNode current = q.poll();
                max = Math.max(current.val, max);
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }        
            }
            l.add(max);
               
        }    
        return l;
            
        }
        
    }