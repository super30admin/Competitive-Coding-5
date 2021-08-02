// Time Complexity : O(N)
// Space Complexity : O(N/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        
        if(root == null) 
            return result; 

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            while(size > 0) {
                
                TreeNode curr = q.poll();
                size--;

                if(max < curr.val) {
                    max = curr.val;
                }
                
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right); 
            } 
            result.add(max); 
        } 
        return result; 
    }
}