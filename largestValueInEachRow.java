// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree (due to recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach:
// Use DFS to traverse the tree, tracking height (level) during recursion.
// If it's the first node at a level, add its value; otherwise, update with the maximum value seen so far.
// Recur for left and right children, increasing level by 1.



import java.util.ArrayList;
import java.util.List;

public class largestValueInEachRow {
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution 
    {
        public void function(ArrayList<Integer> al , TreeNode root ,int h)
        {
            if(root == null)
            {
                return ;
            }
            else
            {
                if(h==al.size())
                {
                    al.add(root.val);
                }
                else if(h< al.size())
                {
                    int get = al.get(h);
                    int max = Math.max(get,root.val);
                    al.set(h,max);
                }
                function(al,root.left,h+1);
                function(al,root.right,h+1);
            }
        }
        public List<Integer> largestValues(TreeNode root) {
            ArrayList<Integer> al = new ArrayList<>();
            function(al,root,0);
            return al;
        }
    }
}
