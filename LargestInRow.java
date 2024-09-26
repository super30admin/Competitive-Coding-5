import java.util.*;

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

public class LargestInRow {
    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        result.add(root.val);
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root,int depth){
        //base
        if(root==null) return;
        if(result.size() == depth){
            result.add(root.val);
        }
        if(result.size()!=depth){
            result.set(depth,Math.max(result.get(depth),root.val));
        }

        //logic
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
