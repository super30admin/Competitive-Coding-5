// Time Complexity : O(n) as we traverse each node in the tree.
// Space Complexity : O(n/2) i.e. maximum number of nodes a level can have in a binary tree, whereas asymptotically it is O(n); n is the number of nodes.
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
    private List<Integer> output = new ArrayList();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)    return new ArrayList();
        
        getLargestValue(root, 0);
        
        return output;
    }
    
    private void getLargestValue(TreeNode node, int level){
        
        if(node == null)    return;
        
        //checks whether the output arraylist contains elements based on how many levels are currently covered and adds the current element to the output arraylist
        if(output.size() == level){
            output.add(node.val);
        }else{   
        //here we check whether the newly added value is greater than the previously added value of the node
            output.set(level, output.get(level) < node.val ? node.val: output.get(level));
        }
        
        //recursive call with passing the left node of the current node
        getLargestValue(node.left, level+1);
        
        //recursive call with passing the right node of the current node
        getLargestValue(node.right, level+1);
        
    }
}
