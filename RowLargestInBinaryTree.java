// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes 100% Time Efficient
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RowLargestInBinaryTree {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if(root==null) //Base case
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>(); //Queue to add nodes in sequential order
        q.add(root); //Initiating the queue
        while(!q.isEmpty()){
            int size = q.size(); //For each level - to control the loop
            int maximumAtLevel= Integer.MIN_VALUE;
            for(int i=0; i<size; i++){ //For loop runs for total for one single level
                TreeNode temp = q.poll(); //Each node in each level

                /* Adding children below */
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                if(temp.val>maximumAtLevel){
                    maximumAtLevel=temp.val;
                }
//                result.add(temp.val);
            }
            result.add(maximumAtLevel);
        }
        return result;
    }

    public static void main(String... args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);
        List<Integer> result = largestValues(node);
        for(int i: result){
            System.out.println(i);
        }

    }

}
