/*
Runtime complexity - O(N) where all the elements of the tree are traversed once
Space complexity - Besides the output list, we are using an intermediatary queue to store each nodes - O(H) where H is the maximum breadth of the tree
*/

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
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
            return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            int maxval=Integer.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.remove();
                maxval=Math.max(maxval,curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            list.add(maxval);
        }
        return list;
    }
}
