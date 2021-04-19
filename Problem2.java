//Find Largest Value in Each Tree Row
//tc - O(n) n - number of nodes
//sc- O(n) for the queue
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(p.largestValues(root));


    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i< size; i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            res.add(max);
            
        }
        return res;
        
    }
    
}
