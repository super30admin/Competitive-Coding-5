// Time Complexity : O(n) traverses through all nodes of tree
// Space Complexity : O(n) in worst case for queue space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        //int max = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr != null){
                    max = Math.max(max, curr.val);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
