import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class LargestValues {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return res;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root==null) return;
        //logic
        if(res.size()==level){
            res.add(root.val);
        } else{
            res.set(level,Math.max(root.val,res.get(level)));
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}