// Time Complexity :O(n)
// Space Complexity :O(n/2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach:
//We will use bfs, travel through each level maintain a size to indentify in which level we are and then see for the max value at that level

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
        List<Integer>result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i =0;i<size;i++){
                TreeNode currNode = q.poll();
                max = Math.max(currNode.val,max);

                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null){
                    q.offer(currNode.right);
                }
            }//for
            result.add(max);
        }//while
        return result;
    }
}
