package CompetitiveCoding5;

import java.util.ArrayList;
import java.util.List;

public class MaxAtEachLevel {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size() == level){
            result.add(root.val);
        }
        else {
            if (result.get(level) < root.val) {
                result.set(level, root.val);
            }
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        System.out.println(new MaxAtEachLevel().largestValues(root));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
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


