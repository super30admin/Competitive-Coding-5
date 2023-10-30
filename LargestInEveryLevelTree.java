// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None

public class LargestInEveryLevelTree {
    class Solution {
        private List<Integer> result;

        public List<Integer> largestValues(TreeNode root) {
            result = new ArrayList<>();

            if(root == null)
                return result;

            // Queue<TreeNode> q = new LinkedList<>();
            // q.add(root);

            // while(!q.isEmpty()){
            //     int size = q.size();
            //     int max = Integer.MIN_VALUE;
            //     for(int i = 0; i < size; i++){
            //         TreeNode popped = q.poll();
            //         max = Math.max(max, popped.val);
            //         if(popped.left != null){
            //             q.add(popped.left);
            //         }
            //         if(popped.right != null){
            //             q.add(popped.right);
            //         }

            //     }
            //     result.add(max);
            // }

            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode root, int level){
            if(root == null)
                return;

            if(result.size() == level){
                result.add(root.val);
            }

            if(root.val > result.get(level)){
                result.set(level, root.val);
            }

            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
