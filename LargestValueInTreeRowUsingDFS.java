// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class LargestValueInTreeRowUsingDFS {

    List<Integer> result ;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    public void helper(TreeNode root, int level)
    {
        if(root == null)return;
        if(level == result.size())
        {
            result.add(root.val);
        }
        else{
            int num = result.get(level);
            result.set(level,Math.max(num,root.val));
        }

        level++;
        helper(root.left,level);
        helper(root.right,level);
    }
}
