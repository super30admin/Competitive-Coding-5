// Time Complexity :O(n) where n is the number of nodes
// Space Complexity :O(h) where h is the height of the binary tree and h = log(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LargestValueInEachTreeRow {
    private List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }

        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int level){
        //base
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(node.val);
        }else{
            result.set(level, Math.max(result.get(level), node.val));
        }
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
