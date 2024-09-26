// Time Complexity :O(n) n is number of leaf nodes
// Space Complexity :O(n) n is number of leaf nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i =0; i<size;i++){
                TreeNode curr = q.poll();
                if(max<curr.val)max=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(max);
        }
        
        return result;
    }
}