//Time Complexity : O(n)
//Space Complexity : O(h) Height of the tree
//Runs successfully on leetcode
//No Problem

//Here we will be traversing the tree in DFS manner. If the level is equal to the size of the list,
//We'll be adding the current element to the maximum because that'll be the fist element of that level



import java.util.ArrayList;
import java.util.List;

public class Competitive_Coding_5_Problem_2_largestOnLevel {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public void helper(TreeNode root, int level)
    {
        if(root == null) return;
        if(ans.size()==level)
        {
            ans.add(root.val);
        }
        else
        {
            int a =ans.get(level);
            if(root.val > a)
            {
                ans.set(level,root.val);
            }
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
