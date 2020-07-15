/**
 * Time: O(n)  n-nodes in the tree
 * Space:O(n) queue size for bfs and height of tree in dfs
 */

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
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        // BFS
        res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size>0){
                size--;
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left != null)q.offer(curr.left);
                if(curr.right != null)q.offer(curr.right);
            }
            res.add(max);
        }
        // helper(root,0);


        return res;
    }
    private void helper(TreeNode node, int level){
        if(node == null) return;

        if(res.size() == level){
            res.add(node.val);
        }else{
            int val = res.get(level);
            if(node.val > val)
                res.set(level,node.val);
        }

        helper(node.left,level+1);
        helper(node.right,level+1);
    }
}