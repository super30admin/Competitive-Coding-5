// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        
        List<Integer> ans = new ArrayList();
        if(root==null) return ans;
        
        int max = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++) {
                
                TreeNode t = q.poll();
                if(max<t.val) max=t.val;
                
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
