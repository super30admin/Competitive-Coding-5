// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

        List<Integer> result = new ArrayList();

        if(root == null)
            return result;


        //normal BFS
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        //calculate the max value at each level
        while(!q.isEmpty())
        {
            int len = q.size();

            int max = Integer.MIN_VALUE;

            for(int i=0; i<len; i++)
            {
                TreeNode node = q.remove();

                if(node.val > max)
                    max = node.val;

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);

            }

            //keep adding each level's max to result
            result.add(max);
        }

        return result;

    }
}
