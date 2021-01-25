Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/


BFS: 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: traver the tree and search for the largest elememt.  keep 
// a track of the number of elements at each row with the help of a size variable.

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
//bfs
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> finallist = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
                if(curr.val>=max){
                    max=curr.val;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            finallist.add(max);
        }
        return finallist;
    }
}



DFS: 
// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: traver the tree and search for the largest elememt.  keep 
// a track of the number of elements at each row with the help of a size variable.
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
    List<Integer> finallist = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new LinkedList<>();
        dfs(root, 0);
        return finallist;
    }
    public void dfs(TreeNode root, int level){
        //base
        if(root==null) return;
        
        //logic
        if(finallist.size()<=level){
            finallist.add(root.val);
        }
        else{
            int currmax=Math.max(finallist.get(level),root.val);
            finallist.set(level,currmax );
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}