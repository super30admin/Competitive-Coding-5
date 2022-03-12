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
 
    binary tree
    both positive/ negative
    return an array 0-> 1
 
    TC O(N)
    SC O(N/2 + 1)
 
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        if (root == null)
        {
            return new ArrayList<>();
        }
        
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            for (int i=0; i<size; i++)
            {
                TreeNode remove = queue.remove();
                
                if (remove.val > max)
                {
                    max = remove.val;
                }
                
                if (remove.left != null)
                {
                    queue.add(remove.left);
                }
                
                if (remove.right != null)
                {
                    queue.add(remove.right);
                }
            }
            
            result.add(max);
        }
        
        return result;
    }
}
