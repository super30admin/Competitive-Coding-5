import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(N) n is the number of nodes of tree
// Space Complexity : O(W) W is the max width of the tree
// Did this code successfully run on Leetcode : Y 
// Any problem you faced while coding this :


public class LargestValueInTree {
     public List<Integer> largestValues(TreeNode root) {
       

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
         if(root == null)
                return result;
        while(!q.isEmpty())
        {
            
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i =0; i< size; i++)
            {
            TreeNode curr = q.poll();
            if(curr.val > max)
                max = curr.val;
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right !=null)
                q.add(curr.right);    
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestValueInTree t = new LargestValueInTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        // Function call
        System.out.println(t.largestValues(root).toString());
    }
}
