// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    //DFS O(n) O(h)
    // List<Integer> result;
    // public List<Integer> largestValues(TreeNode root) {
    //     result= new ArrayList<>();
    //     dfs(root,0);
    //     return result;
    // }
    // private void dfs(TreeNode root,int level){
    //     if(root==null) return;
    //     if(result.size()==level){
    //         result.add(root.val);
    //     }
    //     result.set(level,Math.max(root.val,result.get(level)));
    //     dfs(root.left,level+1);
    //     dfs(root.right,level+1);
    // }
}