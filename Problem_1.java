// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// DFS of the tree, pre-order and if the lenght is same as the index, then add it to the result; else update the value in the list by finding the max with the curr value and the arr.index value
// Your code here along with comments explaining your approach
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
        // null
        if( root == null ) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        // base
        if( root == null ) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }else{
            int current = result.get(level);
            if(current < root.val){
               result.set(level, root.val);
            }
        }
        // left child
        dfs(root.left, level+1);
        // st.pop()
        // right child
        dfs(root.right, level+1);
    }
}

// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         // null
//         if(root == null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             int max = Integer.MIN_VALUE;
//             for( int i = 0; i< size; i++){
//                 TreeNode temp = q.poll();
//                 if( max < temp.val){
//                     max = temp.val;
//                 }
//                 // check left child
//                 if(temp.left != null){
//                     q.add(temp.left);
//                 }
//                 // check right child
//                 if(temp.right != null){
//                     q.add(temp.right);
//                 }
//             }
//             result.add(max);
//         }
//         return result;
//     }
// }
