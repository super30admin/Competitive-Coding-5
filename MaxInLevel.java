// Time Complexity : O(n) n is the number of nodes in the tree.
// Space Complexity : O(n) n is the number of nodes in the tree and because we used the queue for BFS.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
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

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            int size = que.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i<size; i++)
            {
                TreeNode node = que.poll();
                max = Math.max(max, node.val);

                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
            }

            result.add(max);
        }
        return result;
    }
}