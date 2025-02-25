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
class LargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)
        return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode cur = q.poll();
                max=Math.max(max,cur.val);
                if(cur.left!=null)
                q.add(cur.left);
                if(cur.right!=null)
                q.add(cur.right);
            }
            res.add(max);

        }
        return res;
    }
}
//tc:O(n)
//sc:O(n), where n is the no of nodes in the tree