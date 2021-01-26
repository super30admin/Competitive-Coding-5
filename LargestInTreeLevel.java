/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public List<Integer> largestValues(TreeNode root) 
    {
        
        
        List<Integer> output = new ArrayList<>();
        
        if(root == null ) return output;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while( !queue.isEmpty())
        {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            for( int i=0 ; i<size; i++)
            {
                TreeNode current = queue.poll();
                
                max = Math.max( max, current.val);
                
                if(current.left != null)
                    queue.add(current.left);
                
                if(current.right != null)
                    queue.add(current.right);
            }
            
            
            output.add(max);
            
        
        }
        
        return output;
        
    }
}