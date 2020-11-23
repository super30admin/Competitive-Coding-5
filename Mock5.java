// Time Complexity : O(n) Tonal no of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Mock5 {

    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {

        result = new ArrayList<>();
        //edge
        if(root==null) return result;

        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {

        //base
        if (root==null) return;

        //logic
        if(level==result.size()){
            result.add(Integer.MIN_VALUE);
        }
        int max = Math.max(result.get(level), root.val);
        result.set(level,max);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

    public List<Integer> largestValuesBFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        //edge
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        ((LinkedList<TreeNode>) q).add(root);

        while (!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                max= Math.max(max, curr.val);
                if(curr.left!=null) ((LinkedList<TreeNode>) q).add(curr.left);
                if(curr.right!=null) ((LinkedList<TreeNode>) q).add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}


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
