/**
Time Complexity : O(N)
Space Complexity : O(D)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    
    public List<Integer> largestValues(TreeNode root) 
    {
        List<Integer> output = new ArrayList<>();
        
        dfs(root, 0, output);
        
        return output;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> output)
    {
        if(root == null)
            return;
        
        if(output.size() == level)
        {
            output.add(root.val);
        }
        else
        {
            int prev = output.get(level);
            if(root.val > prev)
            {
                output.set(level, root.val);
            }
        }
        
        if(root.left != null)
            dfs(root.left, level + 1, output);
        
        if(root.right != null)
            dfs(root.right, level + 1, output);
        
    }
}