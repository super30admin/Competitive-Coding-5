/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//DFS Solution
//time complexity: O(n) where n is the total number of nodes in the tree
//space complexity: O(logn) where logn is the height of the binary tree
//executed on leetcode: yes
/**)
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return result;
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root,int level)
    {
        if(root==null) return;
        if(level==result.size())
        {
            result.add(root.val);
        }
        else
        {
            int curr_max = result.get(level);
            result.set(level,Math.max(curr_max,root.val));
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
**/
//bfs solution
//time complexity: O(n) we are traversing every node once
//space complexity: O(n/2) where n is the total number of leaf nodes at the last level of the tree
//executed on leetocode: yes

class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;++i)
            {
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
   
}