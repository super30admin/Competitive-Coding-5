
// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if(root== null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int temp = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp = Math.max(curr.val,temp);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
            //temp = Integer.MIN_VALUE;
        }
        return result;
    }
}
