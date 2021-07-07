//Time Complexity : O(N) as all the nodes in the tree are visited
//Space Complexity : O(N). recursive stack occupies O(N) space
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return result;
        }
        //helper function to perform dfs
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        //at each level determine the max value
        int max = Integer.MIN_VALUE;
        //check the level
        if(result.size() == level){
            //if the current node's value is larger than the max value then change the max
            if(max <= root.val){
                result.add(root.val);
            }
        }
        //if teh level is same check the value of the node on the other side of the tree and if max , update it in the result
        else{
            if(result.get(level)<root.val){
                result.set(level,root.val);
            }
        }
        //continue the traversal in the left and right subtree
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}




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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new  LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            
            int currMax = Integer.MIN_VALUE;
            
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                
                if(curr.val > currMax){
                    currMax = curr.val;
                }
                
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
                  
            }
            
            result.add(currMax);
            
        }
        return result;
        
    }
}