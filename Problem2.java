import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
/*
Maximum element in each level
approach: use dfs or bfs and do a level order traversal and update the maximum in each level.
time: O(n)
space: bsf: O(leaf nodes) dfs: O(height)
 */
public class Problem2 {
    /*
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res =  new ArrayList<>();
        if(root==null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int dep) {
        if(root==null) return;

        if(dep==res.size()) {
            res.add(root.val);
        }
        else {
            res.set(dep, Math.max(res.get(dep), root.val));
        }

        if(root.left!=null) dfs(root.left, dep+1);
        if(root.right!=null) dfs(root.right, dep+1);
    }

     */
}
