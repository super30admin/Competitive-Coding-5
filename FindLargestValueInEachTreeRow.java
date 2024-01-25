// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size= q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                max= Math.max(curr.val, max);

                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }

            }
            result.add(max);
        }
        return result;
    }
}