import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//tc = o(n)
//sc = o(n)
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
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return list;

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                max = Math.max(max,current.val);
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }


            }
            list.add(max);


        }
        return list;
    }
}