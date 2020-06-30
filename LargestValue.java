//<------BFS------->
//Time Complexity :- O(n) no of nodes in the tree
//Space Complexity :- O(n)
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
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
		//if(max < curr.val){	// compare all the elements and update the largest value
                //    max = curr.val;
                //}
                max = Math.max(max, curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}

//Time Complexity :- O(n)
//Space Complexity :- O(h) height of the tree / O(n)
//LeetCode :- Yes
//Logic :- recursive dfs solution

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
        List<Integer> largest_val = new ArrayList<>();
        //edge
        if(root == null) return largest_val;
        
        dfs(root, largest_val, 0);
        return largest_val;
    }
    
    private void dfs(TreeNode root, List<Integer> largest_val, int level){
        //base
        if(root == null) return;
        //logic
        if(level == largest_val.size()){
            largest_val.add(root.val); // add at current level
        }else{
            largest_val.set(level, Math.max(largest_val.get(level), root.val)); // get current root value and if max replace it
        }
        
        dfs(root.left, largest_val, level+1);
        dfs(root.right, largest_val, level+1);
    }
}


