// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    List<Integer> result = new ArrayList<>();		// List to record the depth and corresponding largest value
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){			// base case
            return new ArrayList<>();
        }
    
        dfs(root, 0);			// call the dfs function recursively to traverse through all the elements
        
        return result;
        
    }
    
    private void dfs(TreeNode root, int depth){
        // base case
        if(root == null){
            return;
        }
        //logic

        if(result.size() > depth){			// if it already contains, compare the values and update the respective largest value at each level
            int temp  = Math.max(result.get(depth), root.val);
            result.set(depth, temp);
        }else{
            result.add(root.val);			// if traversing through the depth for the first time, add it to the map
        }
        dfs(root.left, depth + 1);			// traverse through the left side
        dfs(root.right, depth + 1);			// traverse through the right side        
    }
}