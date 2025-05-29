import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity: O(n)
// Space Complexity: O(n)
public class problem1 {
      public class TreeNode {
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
        List<Integer> res= new ArrayList<>();
        if(root==null){return res;}

        Queue<TreeNode> q= new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size= q.size();
            int max= Integer.MIN_VALUE;
            for (int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                max= Math.max(curr.val, max);
                if (curr.left!=null){
                   q.add(curr.left);
                }
                if (curr.right!=null){
                    q.add(curr.right);

                }
            }
            res.add(max);
        }


        return res;
    }
}
