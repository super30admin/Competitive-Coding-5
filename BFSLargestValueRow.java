// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    public List<Integer> largestValues(TreeNode root) {
        //base case
        if(root==null) return new ArrayList();
        
        int max=Integer.MIN_VALUE;
        List<Integer>list = new ArrayList();
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        list.add(root.val);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    if(max<node.left.val){
                        max=node.left.val;
                    }
                }
                
                if(node.right!=null){
                    q.add(node.right);
                    if(max<node.right.val){
                        max=node.right.val;
                    }
                }
                
            }
            list.add(max);
        }
        list.remove(list.size()-1);
        return list;
    }
}
