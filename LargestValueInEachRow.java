// Time Complexity :O(n) where n is the number of nodes
// Space Complexity : O(h) height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//BFS Approach

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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {

        result  =new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int max = Integer.MIN_VALUE;
            int size = q.size();

            for(int i = 0; i < size ; i++){

                TreeNode curr = q.poll();

                if(curr.val > max)
                    max = curr.val;

                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}

//DFS Approach
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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {

        result = new ArrayList<>();

        if(root == null)
            return result;
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root, int depth , List<Integer> result){

        //base case
        if(root == null)
            return;

        //logic
        if(depth == result.size()){
            result.add(root.val);
        }
        else{
            result.set(depth,Math.max(result.get(depth),root.val));
        }
        dfs(root.left,depth+1,result);
        dfs(root.right,depth+1,result);
    }
}