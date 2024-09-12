//DFS approach
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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;  
        dfs(root,0);
        return result;
    }
   
    private void dfs(TreeNode root,int level){
        if(root == null) return;
       
        if(result.size() == level){
            result.add(root.val);
        }
        else{
            result.set(level,Math.max(result.get(level),root.val));
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

/*
Time complexity:O(h) height of the tree
Space complexity: O(h) at any point n nodes in a recursive stack
*/



//BFS approach

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null ) return result;
       
        Queue<TreeNode> q = new LinkedList<>();
        //independent
        q.add(root);
       
        int size = 0;
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            size = q.size();
            //level traversing
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left != null ) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(max);
       
        }
       return result;
    }
}

/*
Time Complexity: O(n) traversing every node
At the leaf the complexity is O(n/2)  ie O(n) space complexity
*/

