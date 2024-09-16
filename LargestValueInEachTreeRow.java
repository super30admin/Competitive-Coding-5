import java.util.*;
public class LargestValueInEachTreeRow {
    public static List<Integer> result;
    public static List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        
        Queue<TreeNode> q  = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            int max = Integer.MIN_VALUE;
            
            for(int i =0;i<size;i++)
            {   
                TreeNode curr = q.poll();
                
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                
                max = Math.max(max,curr.val);
            }
            
            result.add(max);
        }
        
        return result;
        
    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        root.left=three;
        root.right=two;
        three.left=five;

        List<Integer> ans = largestValues(root);

        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}
