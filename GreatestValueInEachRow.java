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
class GreatestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        if(root == null)
            return new ArrayList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = myQueue.poll();
                max = Math.max(max, curr.val);

                //LeftTree
                if(curr.left != null)
                    myQueue.add(curr.left);

                //RightTree
                if(curr.right != null)
                    myQueue.add(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}