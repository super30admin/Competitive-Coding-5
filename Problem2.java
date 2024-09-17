//O(N) time O(1) space

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
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return result;
        q.add(root);

        TreeNode node;
        int size;
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            size = q.size();
            for(int i=0;i<size;i++){
                node = q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                max = Math.max(max, node.val);
            }
            result.add(max);
        }
        return result;
    }
}