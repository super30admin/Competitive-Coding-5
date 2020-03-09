/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class GetLargestInRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root ==null){
            return new LinkedList<>();
        }
        List<Integer> result =  new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        result.add(root.val);
        while(!q.isEmpty()){
            int level = q.size();
            int max_val = Integer.MIN_VALUE;
            for(int i=0;i<level;i++){
                TreeNode current = q.poll();
                if(current.left!=null){
                    max_val = Math.max(current.left.val,max_val);
                    q.add(current.left);
                }
                if(current.right!=null){
                    max_val = Math.max(current.right.val, max_val);
                    q.add(current.right);
                }
            }
            result.add(max_val);
        }
        result.remove(result.size()-1);
        return result;
    }
}