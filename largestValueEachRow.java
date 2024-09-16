// Time Complexity :O(n)  n-length of nodes in the tree
// Space Complexity :O(h)  // Stack Space
// Did this code successfully run on Leetcode :yes
//DFS
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
class Solution {
    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
        list=new ArrayList<>();
        if(root==null) return list;
        dfs(root,0);
        return list;
    }
    private void dfs(TreeNode root,int depth)
    {
        if(root==null) return;
        
        if(list.size()==depth)
            list.add(root.val);
        else
        list.set(depth,Math.max(list.get(depth),root.val));
            
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}

/* 
//BFS

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

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                max=Math.max(temp.val,max);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            list.add(max);
            max=Integer.MIN_VALUE;
        }
        
        return list;
    }
}
*/