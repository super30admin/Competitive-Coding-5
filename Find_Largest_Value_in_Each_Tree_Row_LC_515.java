/*Time complexity -  O(N) as we will visit all the nodes
Space Complexity -  O(n) (maximum number of nodes at any level) or max ( width of tree)
For a binary tree, the maximum width can be up to O(n/2) = O(n)
in the worst case (for a complete or full binary tree). */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row_LC_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); //one
            int max = Integer.MIN_VALUE;
            for(int i=0 ; i <size; i++){ // 1
                TreeNode num = q.poll();
                if(num.val > max) {
                    max = num.val; //5
                }

                if(num.left != null) {
                    q.offer(num.left);
                }
                if(num.right != null) {
                    q.offer(num.right);
                }
            }
            result.add(max); //[1]
        }
        return result;
    }
}

/*
Time complexity - O(N) as we are visitng all nodes
Space complexity - O(H) as in recursive stack the height of tree stack will be added
*/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level,List<Integer> result) {
        //base case
        if (root == null) return;

        //logic
        if(result.size() == level) {
            result.add(root.val);
        } else { //keep checking the max for each level
            result.set(level, Math.max(result.get(level), root.val));
        }

        helper(root.left, level+1,result);

        helper(root.right, level+1,result);


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
