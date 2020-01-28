/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //base case
        if(root == null)
            return result;
        //queue for bfs
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = que.size();
            //for every element of the level
            for(int i =0; i<size; i++){
                TreeNode curr = que.poll();
                //update max value if encountered element is greater
                if(curr.val>max)max=curr.val;
                //process the added node
                if(curr.left!= null) que.add(curr.left);
                if(curr.right!= null) que.add(curr.right);                 
            }
            //after the level size reaches 0
            //add currmax to the result List
            result.add(max);
        }
        //return output
        return result;
    }
}