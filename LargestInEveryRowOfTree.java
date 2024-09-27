// Time Complexity : O(n)
// Space Complexity : O(h) height of a tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use level order traversal here and at every level 
// We will take the max of the value and store in a list
// When the the traversal is over we will have our result
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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            int val = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(node != null){
                if(node.val > val)
                    val = node.val;
                q.add(node.left);
                q.add(node.right);
                }
            }
                ans.add(val);
        }
        ans.remove(ans.size()-1);
        return ans;
    }
}