//Time Complexity : O(n)
//Space Complexity : constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes



class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                maxValue = Math.max(temp.val,maxValue);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            result.add(maxValue);
        }
        return result;
    }
}
