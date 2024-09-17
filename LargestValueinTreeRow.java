// Time Complexity :O(n) n: Number of nodes of tree
// Space Complexity : O(maximum width of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// BFS Approach. Ass your nodes to queue and iterate it over the size of it.
// take a temp variable to store the maximum element and keep on check for the elements till the size (which is in a row/level of tree)
// Add the left and right nodes of the popped element and add the max one to output list created as global variable.
// initialized temp to 0 again after adding it to the output, as we need to start over for each row.

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
        if(root==null){
            return new ArrayList<Integer>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        q.add(root);
        //output.add(root.val);

        while(!q.isEmpty()){
            int size = q.size();
            int temp=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){

                TreeNode pop = q.poll();
                if(temp<pop.val){
                    temp = pop.val;
                }else{
                    temp = temp;
                }
                if(pop.left!=null){
                    q.add(pop.left);
                }
                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            output.add(temp);
            temp=0;
        }
        return output;
    }
}