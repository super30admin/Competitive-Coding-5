//TC:O(N)
//SC:O(H) maxdepth


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> list =  new ArrayList<>();
    
    public List<Integer> largestValues(TreeNode root)
    {
        if(root==null ) return list;
        
        dfs(root,0);
        
        return list;
    }
    
    
    
    public void dfs(TreeNode root,int level)
    {
        if(level==list.size())
        {
            list.add(root.val);
        }
        
        else
        {
            if(root.val>list.get(level))
                list.set(level,root.val);
        }
        
        if(root.left!=null) dfs(root.left,level+1);
        if(root.right!=null) dfs(root.right,level+1);   
    }
 
}