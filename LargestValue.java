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
        findMax(root,result,0);
        return result;

    }

    public void findMax(TreeNode root,List<Integer> result,int level){
        if(root==null) return;
        if(result.size()==level){
            result.add(root.val);
        }

        else result.set(level,result.get(level)<root.val?root.val:result.get(level));

        findMax(root.left,result,level+1);
        findMax(root.right,result,level+1);

    }

}