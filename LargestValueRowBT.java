import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Time Complexity: O(n)
// Space Complexity: O(h)
//Approach: BFS

public class LargestValueRowBT {
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
            ArrayList<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                int max = Integer.MIN_VALUE;
                for(int i=0;i<size;i++){
                    TreeNode n = q.poll();
                    max = Math.max(max, n.val);
                    if(n.left != null){
                        q.add(n.left);
                    }
                    if(n.right != null){
                        q.add(n.right);
                    }
                }
                result.add(max);
            }
            return result;
        }
    }
}
