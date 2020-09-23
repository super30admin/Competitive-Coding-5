// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int qSize = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<qSize;i++) {
                TreeNode node = q.poll();
                max=Math.max(max,node.val);
                if(node.left!= null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }
}
