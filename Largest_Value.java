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
    //Time O(N)
    //Space O(H)
    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        helper(root , 0);
        return list;
    }
    public void helper(TreeNode root , int level)
    {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        if(list.size() == level)
        {
            list.add(root.val);
        }
        else
        {
            list.set(level , Math.max(list.get(level) , root.val));
        }
        helper(root.left , level+1);
        helper(root.right , level+1);
    }
}