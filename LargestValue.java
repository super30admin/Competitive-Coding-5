// Time Complexity : O(n) n nodes of the tree
// Space Complexity : O(n/2) => O(n) where n/2 is obtained from the Queue size i.e. the maximum queue size will be the diameter of the tree.
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
 
 // Used BFS to do level order traversal.
 // using level order traversal to to get the values at each level.
 // And store the max value at each level in a list.
 
 
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root ==  null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>(); 
        Queue<TreeNode> que = new LinkedList();
        que.add(root); // 1
        
        while(!que.isEmpty()){
            int size = que.size();
            result.add(Integer.MIN_VALUE);
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                result.set(result.size()-1, Math.max(result.get(result.size()-1),node.val));
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }
        return result;
    }
}
