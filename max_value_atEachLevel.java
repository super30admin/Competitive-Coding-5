// Time Complexity : O(n) iterating through each level
// Space Complexity : O(n) width of the tree for the queue
// Did this code successfully run on Leetcode : successful
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Iterative soln for BFS using queue
// will add the root to the queue initially and vary the size of the queue at each level
//will run a for loop take out (poll) each fifo elements until that size and will check for its the left and right values of the current level nodes and add them to the queue
// will compare to the other nodes and find tyhe max among them
import java.util.ArrayList;
import java.util.*;

public class max_value_atEachLevel {
    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(){
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> bfs(TreeNode root){
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return output;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
            output.add(max);
        }
        return output;
    }

    public static void main(String [] args){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(8);       
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(9);
        List<Integer> result = bfs(node);
        result.forEach(System.out::print);
    }

}
