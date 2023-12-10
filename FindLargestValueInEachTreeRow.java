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
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        // bfs(root, result);
        dfs(root, result, 0);
        return result;
        
    }

    // Time Complexity: O(n) 
    // Space Complexity: O(h)
    private void dfs(TreeNode root, List<Integer> result, int level){
        if(root == null) return;

        if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level, Math.max(root.val, result.get(level)));
        }


        dfs(root.left, result, level+1);
        dfs(root.right, result, level + 1);

    }

    // Time Complexity: O(n) 
    // Space Complexity: O(n)
    private void bfs(TreeNode root, List<Integer> result){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()  != 0){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(max);
        }

    }
}