// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {

        

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){ //TC- O(n), SC- will be maximum of number of nodes stored in queue at a timeO(n/2)

            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<size;i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                  q.add(curr.right);
                }
                
            }
            result.add(max);
        }


      return result;
        
    }
}



