// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>>als;
    public List<Integer> largestValues(TreeNode root) {
        
        if(root==null) return new ArrayList();
        
        int largeNumber=Integer.MIN_VALUE;
        List<Integer>l = new ArrayList();
        als =  new ArrayList();
        largValues(root,0);
        for(List<Integer>li:als){
            int max = Collections.max(li);
            l.add(max);
        }
        return l;
    }
    
    private void largValues(TreeNode node,int level){
        if(node==null) return;
        
        if(als.size()==level){
            List<Integer> list = new ArrayList();
            list.add(node.val);
            als.add(list);
        }else{
            als.get(level).add(node.val);
        }
            
        largValues(node.left,level+1);
        largValues(node.right,level+1);
        
    }
}
