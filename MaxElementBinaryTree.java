/**Leetcode Question - 515 - Find the largest value in each tree row */
/**Algorithm - BFS
 * Add the root element to the queue 
 * maintain a size variable and check the max element add each level
 * add max element to the resultant list
 */
/**TC-O(N)
 * SC-O(N/2 +1) = O(N)
 */
public class MaxElementBinaryTree {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int max = Integer.MIN_VALUE;
                int size = q.size();
                for(int i=0; i<size; i++){
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
    }}
}
