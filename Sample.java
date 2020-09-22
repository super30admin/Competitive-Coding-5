// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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