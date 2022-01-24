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
class Solution { List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        result =new ArrayList<>();
        helper(root,0);

        return result;

    }


    public void helper(TreeNode node,int level){
        if(node==null){
            return;
        }




        if(level==result.size() ){
            result.add(node.val);
        }else{
            if(result.get(level)<node.val){
                result.set(level,node.val);
            }
        }

        helper(node.left,level+1);
        helper(node.right,level+1);

    }



}