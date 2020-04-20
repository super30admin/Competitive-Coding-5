//515.

//time - O(n)
//space - O(n)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //edge
        if(root == null)
        {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> support = new LinkedList<>();
        support.offer(root);
        
        List<Integer> result = new ArrayList<>();
        
        while(!support.isEmpty())
        {
            int layerSize = support.size();
            Integer max = null;
            for(int i = 0; i < layerSize; i++)
            {
                TreeNode current = support.poll();
                if(max == null || max < current.val)
                {
                    max = current.val;
                }
                if(current.left != null)
                {
                    support.offer(current.left);
                }
                if(current.right != null)
                {
                    support.offer(current.right);
                } 
            }
            result.add(max);
        }
        
        return result;
    }
}
