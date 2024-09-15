/**
 * Time Complexity : O(N) where N = number of nodes
 * Space Complexity : O(h) where h = height of the tree
 */

import java.util.List;
import java.util.ArrayList;

//DFS Approach
public class LargestValueInRow {
    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
         list = new ArrayList<>();
        //base
        if(root == null) return list;
        helper(root,0);
        return list;
    }
    
    private void helper(TreeNode root, int index){
        if(root == null) return;
        if(list.size()==index) list.add(root.val);
        else{
            //if(root.val>list.get(index)){
             //   list.set(index,root.val);
            //}
            list.set(index,Math.max(root.val,list.get(index)));
        }
        helper(root.left,index+1);
        helper(root.right,index+1);
    }

}

//BFS approach
/*

public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i){
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }

*/

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