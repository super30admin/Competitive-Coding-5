/*
Thought Process: 
Use BFS approach and find the max in each level.

TC -> O(N) Looping thorugh all the nodes
SC -> O(K) Count of leaf nodes
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
class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode polled = q.poll();
                max = Math.max(max, polled.val);
                if(polled.left != null) q.add(polled.left);
                if(polled.right != null) q.add(polled.right);
            }
            result.add(max);
        }
        return result;
    }
}