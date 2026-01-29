/*
Time Complexity : O(N), go through all nodes in the tree
Space Complexity : O(h), height of the tree in the recursion stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :
We will maintain a result list for keeping the maximum at every level. We will start dfs on the root and pass the level
in the next recursion calls. If the level is encountered the first time, add the current root to the list, if a value for
at level index already exists, compare this value with the root value. Save the maximum of the two at that index and
continue the recursion on the left and right child. At the end the list should have max value for each level at the level index.
*/
import java.util.ArrayList;
import java.util.List;

public class LargestValue {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    void dfs(TreeNode root, int level, List<Integer> result){
        if(root == null) return;

        if(result.size() == level){
            // if the max value for that level doesn't exist already
            result.add(root.val);
        }else {
            // if the value already for level exists, compare it with current root and update
            int temp = result.get(level);
            result.set(level, Math.max(temp, root.val));
        }
        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);
    }
}
