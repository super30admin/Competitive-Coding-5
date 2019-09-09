/*
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// DFS Solution


class Solution {
    public List<Integer> largestValues(TreeNode root) {
            
            List<Integer> result = new ArrayList<Integer>();
        
            dfs(root, 0, result);
        
            return result; 
    }
    
    public void dfs(TreeNode root, int level, List<Integer> result){
        
        // base
        
        if(root == null)    return;
        
        if(result.size() == level){
            
            result.add(root.val);      
        }else{
            
            int cur = result.get(level);
            int max = Math.max(cur, root.val);
            result.set(level, max);
            
        }
        
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}

// Can also be done using BFS by doing the usual level order traveral, but now just keep track of only the 
// largest value in each level.