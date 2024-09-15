// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size=q1.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=q1.poll();
                if(curr.val > max){
                    max=curr.val;
                }
                if(curr.left!=null){
                    q1.add(curr.left);
                }
                if(curr.right!=null){
                    q1.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}