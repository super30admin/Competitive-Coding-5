// Level order traversal
// Pure BFS problem. Use queue and size to mark the level.
// Time complexity = O(n)
// space complexity = O(n/2) = O(n). n is the no. of the nodes in the tree.
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
        List<Integer> lst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root== null) return lst;
        // not null situation.
        // add root node.
        q.add(root);
        // queue is not empty.
        while(!q.isEmpty()) {
            // get the size- crucial.
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i< size;i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }   
            }
            // add at the end of each level.
            lst.add(max);
        }
        return lst;
    }
}