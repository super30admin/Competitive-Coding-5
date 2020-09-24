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
//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>output=new ArrayList();
        if(root==null)
        {
            return output;
        }
        Queue<TreeNode>queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int max=Integer.MIN_VALUE;
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode front=queue.poll();
                if(front.val>max)
                {
                    max=front.val;
                }
                if(front.left!=null)
               {
                queue.add(front.left);
               }
              if(front.right!=null)
              {
                queue.add(front.right);
              }
        }           
            output.add(max);
            
        }
        return output;
        
    }
}