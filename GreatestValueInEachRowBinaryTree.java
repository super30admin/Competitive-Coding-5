// TC - O(n) where n is number of nodes in tree
// SC - O(h) where h is height of tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GreatestValueInEachRowBinaryTree {

    public static class TreeNode {
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

    // BFS Approach
    static class Solution1 {
        public List<Integer> largestValues(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            if (root==null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                int MAX = Integer.MIN_VALUE;

                for (int i=0; i<size; i++) {
                    TreeNode curr = q.poll();
                    if(curr.val > MAX) {
                        MAX = curr.val;
                    }
                    if (curr.left !=null) q.add(curr.left);
                    if (curr.right !=null) q.add(curr.right);
                }

                result.add(MAX);
            }

            return result;
        }
    }

    // DFS Approach
    static  class Solution2 {
        List<Integer> result;
        public List<Integer> largestValues(TreeNode root) {

            result = new ArrayList<>();

            if(root == null)
                return result;
            dfs(root,0,result);
            return result;
        }

        private void dfs(TreeNode root, int depth , List<Integer> result){

            //base case
            if(root == null)
                return;

            //logic
            if(depth == result.size()){
                result.add(root.val);
            }
            else{
                result.set(depth,Math.max(result.get(depth),root.val));
            }
            dfs(root.left,depth+1,result);
            dfs(root.right,depth+1,result);
        }
    }

}
