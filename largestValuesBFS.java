// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.*;

class largestVal {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < sz; i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val, max);
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            result.add(max);
        }
        
        return result;
        
    }
}