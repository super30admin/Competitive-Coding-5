// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    HashMap<Integer,Integer> map = new HashMap<>();		// HashMap to record the depth and corresponding largest value

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){				// base case
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        dfs(root, 0);			// call the dfs function recursively to traverse through all the elements
        
        for(int i = 0; i < map.size(); i++){	// add the all the largest values in order with respect to depth
            result.add(map.get(i));
        }
        
        return result;
        
    }
    
    private void dfs(TreeNode root, int depth){
        // base case
        if(root == null){
            return;
        }
        //logic
        // 0: 2
        // 1: 5
        // 2: 7
        int deep = map.size();
        if(map.containsKey(depth)){			// if it already contains, compare the values and update the respective largest value at each level
            int temp = map.get(depth);
            if(temp < root.val){
                map.replace(depth, root.val);
            }
        }else{
            map.put(depth, root.val);		// if traversing through the depth for the first time, add it to the map
        }
        dfs(root.left, depth + 1);			// traverse through the left side
        dfs(root.right, depth + 1);			// traverse through the right side
        
    }
}