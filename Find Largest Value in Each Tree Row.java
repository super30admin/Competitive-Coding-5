// Time complexity: O(N)
// Space complexity: O(N)
// Leetcode: Yes

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
        //base
        if(root == null){
            return new ArrayList<Integer>();
        }

        //Logic
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            int max = Integer.MIN_VALUE;
            

            for(int i=0; i < size;i++){
                TreeNode curr = q.poll();
                if(max < curr.val) max = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(max);

        }
        return result;

    }
}
