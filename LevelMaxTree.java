//Time complexity : O(n) for both dfs and bfs
//Space complexity: O(height) for dfs and O(width) for bfs
/*Approach 
DFS
-making place for every level and if we go again to that level,we check if it is max then previous val
if yes we overwrite it
BFS
-we are going through each level and inserting max of each level to our result
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class LevelMaxTree {
    public static class TreeNode {
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
       
    //dfs
    List<Integer> result ;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
       if(root ==  null)return;
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            if(root.val > result.get(level)){
                result.set(level,root.val);
            }
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }


    //bfs
    public List<Integer> largestValuesbfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root  == null)return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i <size;i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val,max);
                if(curr.left != null){q.add(curr.left);}
                if(curr.right != null){q.add(curr.right);}
            }
            result.add(max);
        }
        return result;

    }
 
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);

        root.right.right=new TreeNode(9);

        LevelMaxTree obj = new LevelMaxTree();
        System.out.println(obj.largestValues(root));
        System.out.println(obj.largestValuesbfs(root));

    }
}
