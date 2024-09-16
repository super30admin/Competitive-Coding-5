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
class Problem1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            //declaring a size variable
            //size will tell the level of tree
            int size = q.size();
            int max =Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

                max = Math.max(max, curr.val);

            }
            result.add(max);

        }

        return result;

    }
}