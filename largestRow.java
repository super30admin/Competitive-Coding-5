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
       
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            size = queue.size();
           // List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                max = Math.max(max,curr.val);
               // tmp.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);    
            }
            result.add(max);
            //for(Integer i: tmp){
              //  max = Math.max(i,max);
            //}
         
        }
        
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)
