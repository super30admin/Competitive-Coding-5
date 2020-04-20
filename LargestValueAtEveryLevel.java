//Time complexity: O(N) -number of nodes
//Space complexity: O(H)-Height of tree

import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> result=new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {

        if(root==null)
            return result;
        dfs(root, 0);
        return result;
        
        
    }
    
    public void dfs(TreeNode curr, int level)
    {
        if(curr==null)
            return;
        if(result.size()==level)
            result.add(curr.val);
        else
        {
            result.set(level, Math.max(result.get(level), curr.val));
        }
        dfs(curr.left, level+1);
        dfs(curr.right, level+1);
    }
}