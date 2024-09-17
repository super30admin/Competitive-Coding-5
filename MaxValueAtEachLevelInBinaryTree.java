package S30.CompetitiveCoding_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*BFS Solution
Time Complexity : O(n) - touching every node
Space Complexity : O(n/2) - max queue size at last level
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*DFS Solution
Time Complexity : Put: O(n) - touching every node
Space Complexity : O(h) - height of stackframe/tree / O(n) if the tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class MaxValueAtEachLevelInBinaryTree {

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

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                max = Math.max(curr.val,max);

            }
            result.add(max);
        }
        return result;

    }

    public List<Integer> largestValuesDFS(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0,result);
        return result;

    }

    private void dfs(TreeNode root, int level, List<Integer> result){

        if(root == null) return;

        if(result.size() == level){
            result.add(root.val);
        }

        if(root.val > result.get(level)){
            result.set(level,root.val);
        }

        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);

    }
}
