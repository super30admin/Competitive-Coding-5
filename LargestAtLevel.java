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
    List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root== null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0; i< size; i++){
               TreeNode curr = q.poll();
               if(curr.val>max) max= curr.val;
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null)q.add(curr.right);
            }
            result.add(max);
            
        }
        return result;
    }
   
}

//Time complexity- O(n)
//Space Complexity- O(n)