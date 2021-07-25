import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> largestValues(TreeNode root) 
    {
        if(root==null)
            return new ArrayList<>();
        
        List<Integer> result=new ArrayList<>();
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        
        
        
        
        while(!queue.isEmpty())
        {
            int max=Integer.MIN_VALUE;
            int size=queue.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                
                max=Math.max(curr.val,max);
                
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);   
                
            }
            result.add(max);
        }
        return result;
    }
}