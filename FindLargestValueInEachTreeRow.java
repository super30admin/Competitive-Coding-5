// Time Complexity : O(n)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root, int level,List<Integer> result ){
        if(root==null){
            return;
        }

        if(result.size()==level){
            result.add(root.val);
        }else{
            if(result.get(level)<root.val){
                result.set(level,root.val);
            }
        }
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
}
