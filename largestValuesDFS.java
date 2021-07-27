// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        //we send in the root and the current height which is 0 at this level
        dfs(root, 0);
        return result;
        
    }
    
    private void dfs(TreeNode root, int height){
        
        //base
        if(root == null)
            return;
        //logic: if the height is the same as length of list that means we don't have and element at that index  yet
        if(height == result.size()){
            result.add(root.val);
        }

        //if there is already an element, we replace it
        else{
            result.set(height, Math.max(result.get(height), root.val));
        }
        
        dfs(root.right, height + 1);
        dfs(root.left, height + 1);
    }
}