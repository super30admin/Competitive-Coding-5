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
// Time : O(n)
// Space : O(h) # recursion space
class Solution {
    List<Integer> result ;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }

    public void dfs(TreeNode root , int depth){
        // Base case
        if(root == null) return;

        // Logic
        if(depth == result.size()){
            result.add(root.val);
        } else{
            result.set(depth,Math.max(result.get(depth),root.val));
        }
        
        // Recursion
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}


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
// Time : O(n)
// Space : O(n/2)
class Solution {
    List<Integer> result ;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int curr_max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                curr_max = Math.max(curr_max,curr.val);

                if(curr.left!=null){
                    q.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(curr_max);
        }

        return result;
    }
}