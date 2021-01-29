// Time Complexity : O(N)
// Space Complexity : O(N/2) = O(N) | all leaf nodes
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class LargestInaRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null ) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            int max = q.peek().val;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.val > max){
                    max = curr.val;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(max);
        }

        return result;
    }
}
